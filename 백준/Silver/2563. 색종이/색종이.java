
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int SIZE = 100;
		boolean[][] map = new boolean[SIZE][SIZE];
		int num = sc.nextInt();
		
		while(num-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int i = y - 1; i < y + 9; i++) {
				for (int j = x - 1; j < x + 9; j++) {
					map[i][j] = true;
				}
			}
			
		}
		
		
		
		int cnt = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(map[i][j]) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
