import java.util.*;
import java.io.*;

public class Main {
	static int N, M, board[][];
	static boolean nextBoardCheck[][];
	static Queue<int[]> q = new ArrayDeque<>();
	
	static int[][] shift = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		nextBoardCheck = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		setBoarder(0, 0); //외곽 처리
		find(0, 0);  //재귀 함수 실행
	}

	private static void find(int lastCheese, int time) {
		int cheese = 0; //현재 맵에 존재하는 치즈 개수 : 해당 개수가 0일 경우 결과 출력

		//완전 탐색으로 치즈 개수 카운팅 및 사라질 치즈 위치 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] == 1) cheese += 1;
				
				//사방탐색하여 근처에 외곽(2)이 있을 경우
				if(nowIsNearByBorder(i, j)) {
					//외곽 근처인데, 해당 값이 치즈 안쪽(0)이었다면, 채우기 실행 
					if(board[i][j] == 0) {
						setBoarder(i, j);
						//if(board[i][j - 1] == 1) nextBoardCheck[i][j - 1] = true; //예외처리
					}
					nextBoardCheck[i][j] = true;
				}
				else nextBoardCheck[i][j] = false;
			}
		}
		
		//기저조건 : 남은 치즈가 0개일 경우
		if(cheese == 0) {
			System.out.println(time);
			System.out.println(lastCheese);
			return;
		}
		
		//줄어든 치즈 개수 반영
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(nextBoardCheck[i][j]) {
					board[i][j] = 2;
				}
			} 
		}
		
		//D
		//완전 탐색으로 치즈 개수 카운팅 및 사라질 치즈 위치 저장
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if(board[i][j] == 1) cheese += 1;
						
						//사방탐색하여 근처에 외곽(2)이 있을 경우
						if(nowIsNearByBorder(i, j)) {
							//외곽 근처인데, 해당 값이 치즈 안쪽(0)이었다면, 채우기 실행 
							if(board[i][j] == 0) {
								setBoarder(i, j);
								//if(board[i][j - 1] == 1) nextBoardCheck[i][j - 1] = true; //예외처리
							}
							nextBoardCheck[i][j] = true;
						}
						else nextBoardCheck[i][j] = false;
					}
				}
		
		find(cheese, ++time);
	}

	private static boolean nowIsNearByBorder(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + shift[i][0];
			int nc = c + shift[i][1];
			
			if(isOutofIdx(nr, nc)) continue;
			if(board[nr][nc] == 2) return true;
		}
		return false;
	}

	private static void setBoarder(int r, int c) {
		//BFS 사용, 치즈 외곽 부분은 2로 처리
		q.offer(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int temp[] = q.poll();
			r = temp[0];
			c = temp[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + shift[i][0];
				int nc = c + shift[i][1];
				
				if(isOutofIdx(nr, nc) || board[nr][nc] > 0) continue;
				board[nr][nc] = 2;
				q.offer(new int[] {nr, nc});
			}
		}
	}
	
	
	private static boolean isOutofIdx(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= M) return true;
		return false;
	}
}
