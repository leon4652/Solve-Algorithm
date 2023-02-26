import java.io.*;
import java.util.*;
import java.util.*;

public class Main {
	static char[][] map;
	static int R, C, res;
	static HashSet<Character> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		set.add(map[0][0]);
		dfs(0, 0, 1);
		System.out.println(res);
	}

	private static void dfs(int r, int c, int dist) {
		int shift[][] = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
		res = Math.max(res, dist);
		
		for (int i = 0; i < shift.length; i++) {
			int nr = r + shift[i][0];
			int nc = c + shift[i][1];
			
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			if(set.contains(map[nr][nc])) continue;
			set.add(map[nr][nc]);
			dfs(nr, nc, dist + 1);
			set.remove(map[nr][nc]);

		}
	}
}
