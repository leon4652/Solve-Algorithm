import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[21][21];
		int[] dx = { 1, 0, 1, -1 };	// 아래, 오른쪽, 오른쪽 아래 대각선, 오른쪽 위 대각선
		int[] dy = { 0, 1, 1, 1 };
		
		for (int i = 1; i < 20; i++) for (int j = 1; j < 20; j++) map[i][j] = sc.nextInt();

		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {

				int currVal = map[i][j];
				if (currVal == 0) continue;
				
				for (int d = 0; d < 4; d++) {
					int count = 1;
					if (currVal == map[i + dx[d] * -1][j + dy[d] * -1]) continue;
					while (currVal == map[i + dx[d] * count][j + dy[d] * count]) count++;
					if (count == 5) {
						System.out.println(currVal);
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
}