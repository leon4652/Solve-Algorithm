import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr, pick, answer;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = new int[9];
		pick = new int[7];
		answer = new int[7];
		visit = new boolean[9];
		for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();
		
		
		find(0, 0);

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		
	}
	private static void find(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < pick.length; i++) sum += pick[i];
			if (sum == 100) {
				for (int i = 0; i < pick.length; i++) {
					answer[i] = pick[i];
				}
			}
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			
			pick[cnt] = arr[i];
			find(cnt + 1, i + 1);

		}
	}

}
