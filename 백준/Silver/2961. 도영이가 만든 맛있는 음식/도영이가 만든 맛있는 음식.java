
import java.util.Scanner;

public class Main {
	static int num, sourTaste = 1, bitterTaste = 0, result = Integer.MAX_VALUE;
	static int[][] data;
	//신맛 = 사용한 신맛의 곱, 쓴맛 = 사용한 쓴맛의 합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		data = new int[num][2];
		for (int i = 0; i < num; i++) {
			data[i][0] = sc.nextInt(); //신맛
			data[i][1] = sc.nextInt(); //쓴맛
		}
		
		cook();
		System.out.println(result);
	}
	private static void cook() {
		for (int i = 1; i < (1 << num); i++) {
			for (int j = 0; j < num; j++) {
				if ((i & (1 << j)) == 0) continue;
				sourTaste *= data[j][0];
				bitterTaste += data[j][1];

			}

			
			if ((int)Math.abs(sourTaste - bitterTaste) < result) {
				result = (int)Math.abs(sourTaste - bitterTaste);
			}
			sourTaste = 1;
			bitterTaste = 0;
		}
		
	}

}
