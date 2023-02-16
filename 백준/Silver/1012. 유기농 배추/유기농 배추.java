
import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] isVisited;
	static char[][] map;
	static int X, Y, result = 0;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Y = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new char[Y][X];
			isVisited = new boolean[Y][X];
			int num = Integer.parseInt(st.nextToken());
			
            //입력값의 좌표마다 '1' 지정하기
			for (int j = 0; j < num; j++) {
				st = new StringTokenizer(br.readLine());
				int tempI = Integer.parseInt(st.nextToken());
				int tempJ = Integer.parseInt(st.nextToken());
				map[tempI][tempJ] = '1';
			}
            
            //메인 메서드 실행
			findBug();
			
            //출력 및 초기화
			System.out.println(result);
			result = 0;
			
		}
	}

	private static void findBug() {
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (map[i][j] == '1' && !isVisited[i][j]) {
					result++;
					dfs(i, j); //근방 방문한 것으로 밀어버리기
				}
			}
		}
		
	}

	private static void dfs(int y, int x) {
		int[][] shift = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
		isVisited[y][x] = true;
		for (int i = 0; i < shift.length; i++) {
			int newY = y + shift[i][0];
			int newX = x + shift[i][1];
			if (newY < 0 || newX < 0 || newY >= Y || newX >= X 
					|| isVisited[newY][newX] || map[newY][newX] != '1') continue;
			dfs(newY, newX);
		}
	}

}