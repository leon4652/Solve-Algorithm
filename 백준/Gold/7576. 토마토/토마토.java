import java.util.*;
import java.io.*;

public class Main {
	static final int D = 4; //4방탐색
	static int N, M, res = -1;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Pos> q = new ArrayDeque<>(); //BFS
	static int d[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		//맵 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) q.offer(new Pos(i, j, 1));
			}
		}
		
		//메인 메서드
		solve();
		
		//출력
		System.out.println(res);
	}

	
	private static void solve() {
		//BFS 돌려보고 빈칸 있다면 전부 전파되지 않은 것임
		//완전탐색 후 최대 값 = 걸리는 시간이므로 이를 출력
		
		//1. BFS
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			int r = temp.r;
			int c = temp.c;
			int day = temp.day;
			
			if(visit[r][c]) continue;
			visit[r][c] = true;
			
			map[r][c] = Math.max(map[r][c], day);
			
			
			for (int i = 0; i < D; i++) {
				int nr = r + d[i][0];
				int nc = c + d[i][1];
				if(cantGo(nr, nc) || map[nr][nc] == -1) continue; //기저조건
				q.offer(new Pos(nr, nc, day + 1));
			}
			
		}
		
		//2. 탐색
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) return; //전파 실패 : -1 그대로 출력
				if(map[i][j] > 0) max = Math.max(max, map[i][j]);
			}
		}
		res = max - 1;
	}

	static boolean cantGo(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= M) return true;
		return false;
	}
	static class Pos {
		int r, c, day;

		public Pos(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}
}
