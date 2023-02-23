
import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] visited;
	static int[][] map;
	static int res, W, H;
	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			
			if(W == 0 && H == 0) break; //기저조건
			
			res = 0;
			map = new int[W][H];
			visited = new boolean[W][H];

			// 지도 입력
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < H; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 탐색
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < H; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						res += 1;
						dfs(i, j);
					}
				}
			}
			
			System.out.println(res);
		}
	}

	private static void dfs(int r, int c) {		
		int[][] shift = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
		visited[r][c] = true;
		
		for (int i = 0; i < shift.length; i++) {
			int nr = r + shift[i][0];
			int nc = c + shift[i][1];
			
			if(!isOutOfIdx(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) dfs(nr, nc);
		}
	}
	
	static boolean isOutOfIdx(int r, int c) {
		if(r < 0 || c < 0 || r >= W || c >= H) return true;
		return false;
	}
}