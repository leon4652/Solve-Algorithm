
import java.util.*;
import java.io.*;

public class Main {
	static char[][] map;
	static boolean[][] visit;
	static int N, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		//모든 사람
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {				
				if(dfs(i, j, map[i][j])) res += 1;
			}
		}
		System.out.print(res + " ");
		
		//적록색맹
		res = 0;
		visit = new boolean[N][N];
		//덮어쓰기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'G') map[i][j] = 'R'; 
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(dfs(i, j, map[i][j])) res += 1;
			}
		}
		System.out.println(res);
	}
	private static boolean dfs(int r, int c, char color) {
		int[][] shift = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		
		if (outOfIdx(r, c) || visit[r][c] || map[r][c] != color) return false;
		visit[r][c] = true;

		for (int i = 0; i < shift.length; i++) {
			int nr = r + shift[i][0];
			int nc = c + shift[i][1];
			
			dfs(nr, nc, color);
		}
		return true;
	}
	
	static boolean outOfIdx(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N) return true;
		return false;
	}
}
