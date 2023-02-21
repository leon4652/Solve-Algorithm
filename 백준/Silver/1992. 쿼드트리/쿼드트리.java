import java.io.*;
import java.util.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i] = sb.toString().toCharArray();
			}
		}
		
		divide(0, 0, N);
		
		bw.close();
		
	}
	private static void divide(int r, int c, int size) throws IOException {
		int cnt = 0;
		
		for (int i = r; i < (r + size); i++) {
            for (int j = c; j < (c + size); j++) {
				if(map[i][j] == '1') cnt += 1;
			}
		}
		//전체가 0인 경우
		if(cnt == 0) {
			bw.write("0");
			return;
		}
		//전체가 1인 경우
		else if(cnt == size * size) {
			bw.write("1");
			return;
		}
		else {
		//아닐 경우 다시 쪼개기
		bw.write("(");
		int half = size / 2;
		divide(r, c, half);
		divide(r, c + half, half);
		divide(r + half, c, half);
		divide(r + half, c + half, half);
		bw.write(")");
		}
	}
	
	
}