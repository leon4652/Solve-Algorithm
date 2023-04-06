
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, res = Integer.MAX_VALUE;
	static int[][] map;
	static List<virus> virusList = new ArrayList<>(); //바이러스 담을 리스트
	static int[] pick;
	
	static int[][] d = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static Queue<virus> q = new ArrayDeque<>();
	static boolean visit[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		//맵 입력받기
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();

				if(map[i][j] == 2) { 				//바이러스 위치 저장
					virusList.add(new virus(i, j));
				}
			}
		}
		
		//조합으로 바이러스 위치 찾기
		pick = new int[M]; //골라진 바이러스들 인덱스 담을 배열
		comb(0, 0);
		
		//결과 출력
		if(res == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(res);
	}
	private static void comb(int start, int cnt) {
		if(cnt == M) {
			solve();
			return;
		}
		
		for (int i = start; i < virusList.size(); i++) {
			pick[cnt] = i;
			comb(i + 1, cnt + 1);
		}
	}

	private static void solve() {
		visit = new boolean[N][N];
		//조합으로 고른 바이러스들 큐에 삽입
		for (int i = 0; i < M; i++) {
			virus v = virusList.get(pick[i]);
			q.offer(v);
			visit[v.r][v.c] = true;	
		}
		
		//BFS
		int nowTime = -1; 
		while(!q.isEmpty()) {
			
			int size = q.size(); //현재 큐의 사이즈 저장
			while(size-- > 0) {  //저장된 사이즈만큼 큐를 늘리고, 시간을 1초 추가
				virus v = q.poll();
				int r = v.r;
				int c = v.c;
						
				for (int i = 0; i < d.length; i++) {
					int nr = r + d[i][0];
					int nc = c + d[i][1];
					
					if(cantGo(nr, nc)) continue;
					if(map[nr][nc] == 1 || visit[nr][nc]) continue;
					q.offer(new virus(nr, nc));
					visit[nr][nc] = true;
					
				}
			}
			nowTime += 1;
		}
		
		//값이 존재할 경우 최저기록과 비교
		if(check()) res = Math.min(res, nowTime);
	}
	
	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 && !visit[i][j]) return false;
			}
		}
		return true;
	}
	static boolean cantGo(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N) return true;
		return false;
	}
	
	static class virus {
		int r, c;

		public virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			
		}
	}
}
