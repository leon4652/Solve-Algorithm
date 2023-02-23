import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int res, N;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N  = Integer.parseInt(br.readLine());
    	map = new int[N][N];
    	visited = new boolean[N][N];
    	List<Integer> lst = new ArrayList<>();
    	
    	for (int i = 0; i < N; i++) {
    		StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = sb.charAt(j) - 48;
			}
		}
    	
    	int cnt = 0;
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt += 1;
					dfs(i, j);
					lst.add(res);
					res = 0;
				}
			}
		}
    	
    	System.out.println(cnt);
    	int size = lst.size();
    	Collections.sort(lst);
    	for (int i = 0; i < size; i++) {
			System.out.println(lst.get(i));
		}
    }

	private static void dfs(int r, int c) {
		int[][] shift = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
		if(r < 0 || c < 0 || r >= N || c >= N) return;
		if(visited[r][c] || map[r][c] == 0) return;
		
		visited[r][c] = true;
		res += 1;
		
		for (int i = 0; i < shift.length; i++) {
			int nr = r + shift[i][0];
			int nc = c + shift[i][1];
			
			dfs(nr, nc);
		}
		
	}
}