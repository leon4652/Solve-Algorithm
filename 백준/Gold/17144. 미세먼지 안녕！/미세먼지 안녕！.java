
import java.util.*;
import java.io.*;

public class Main {
	static int R, C, T; //입력값
	static int[] cleaner = new int[2]; //0 = r, 1 = c
	static int map[][];
	static Queue<Dust> dustQ = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		boolean check = false;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//공기청정기 위치 저장
				if(!check && map[i][j] == -1) { 
					cleaner[0] = i;
					cleaner[1] = j;
					check = !check;
				}
			}
		}
		
		//T초만큼 반복
		while(T-- > 0) {
			blowDust(); //확산
			//공기청정기 가동(위)
			wind(cleaner[0], cleaner[1], new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}});	
			
			//공기청정기 가동(아래)
			wind(cleaner[0] + 1, cleaner[1], new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}});	
		}
		
		int res = 2; //공기청정기 두 칸(-2) 더할 것임.
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				res += map[i][j];
			}
		}
		System.out.println(res);
	}



	private static void wind(int r, int c, int[][] shift) {
		int cnt = 0;	//방향 스위치 및 종료 트리거
		int save = 0; 	//현재 미세먼지 값 저장
		int last = 0; 	//이전 미세먼지 값 저장
	
		while(cnt != 4) {
			r += shift[cnt][0];
			c += shift[cnt][1];
			
			//만약 이동한 칸이 존재하지 않거나, 공기청정기라면
			if(OutOfIdx(r, c)) {
				r -= shift[cnt][0]; //이전 인덱스로 복귀
				c -= shift[cnt][1];
				cnt += 1; //다음 방향으로 전환
				continue;
			}
			
			save = map[r][c]; //현재 좌표 값을 저장
			map[r][c] = last; //현재 좌표에 이전 값을 넣음
			last = save;	  //현재 값을 이전 값으로 변경
		}
	}



	private static void blowDust() {
		//값 읽어들임
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int now = map[i][j];
				if(now == 0 || now == -1) continue;  	//빈 자리나 공기청정기일 경우 스킵
				dustQ.offer(new Dust(i, j, now)); 		//저장
				map[i][j] = 0;	//초기화
			}
		}
		
		//읽어들인 값을 기반으로 전파 실행
		while(!dustQ.isEmpty()) {
			dustQ.poll().dustSet();
		}
	}



	static class Dust {
		/*
		 * * 1. 미세먼지 확산 구현 : 4방 탐색(OFI, 공기청정기 배제) 
		 * 확산량 : n / 5 원래 자리 : 기존값 - 확산량*(확산된 방향 개수) 
		 * -> 확산은 모든 위치에서 동시에 일어난다. queue에 좌표, 중앙값, (4방 체크 후)확산량을 집어넣어야 할 것이다
		 */
		
		int r, c, value, moveVal;
		
		public Dust(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.value = value;
			moveVal = value / 5;
		}

		private void dustSet() {
			int shift[][] = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
			int cnt = 0;
			for (int i = 0; i < shift.length; i++) {
				int nr = r + shift[i][0];
				int nc = c + shift[i][1];
				
				if(OutOfIdx(nr, nc)) continue;
				map[nr][nc] += moveVal; //미세먼지 전파
				cnt++;
			}
			value -= moveVal * cnt; //확산 후 남은 값
			map[r][c] += value; 	//원래 자리에 남은 값 더해줌.
		}
	}
	
	static boolean OutOfIdx(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C || map[r][c] == -1) {
			return true;
		}
		return false;
	}
}
