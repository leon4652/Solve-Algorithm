
import java.io.*;
import java.util.*;
import java.util.*;

public class Main {
	final static int SIZE = 8;
	static boolean[][] board;
	static boolean[][] tempBoard = new boolean[SIZE][SIZE];
	static int res = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		board = new boolean[M][N];
		
		//값 넣기
		for (int i = 0; i < M; i++) {
			StringBuilder temp = new StringBuilder(br.readLine());
			for (int j = 0; j < N; j++) {
				if(temp.charAt(j) == 'B') board[i][j] = true;
				else board[i][j] = false;
			}
		}
		
		//전체 중 체스판 찾기 i, j = 시작 좌표
		for (int i = 0; i <= M - SIZE; i++) {
			for (int j = 0; j <= N - SIZE; j++) {
				check(i, j);
			}
		}
		
		System.out.println(res);
	}
	private static void check(int r, int c) {
		boolean isBlack = true;
		
		//새로 만든 보드판
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				tempBoard[i][j] = board[r + i][c + j];
			}
		}
		
		int draw = Math.min(checkDraw(isBlack), checkDraw(!isBlack)); //(0, 0) 흑, 백으로 대입
		res = Math.min(res, draw);
	}
	
	private static int checkDraw(boolean isBlack) {
		int cnt = 0;
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(tempBoard[i][j] != isBlack) cnt += 1;
				isBlack = !isBlack; //반전
			}
			isBlack = !isBlack; //반전
		}
		return cnt;
	}		
}
