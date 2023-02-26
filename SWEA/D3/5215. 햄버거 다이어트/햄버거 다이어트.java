

import java.util.Scanner;

public class Solution {
	static int res;
	static int taste[], cal[];
	static int N, L;
	static boolean visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 0;
		while(t++ < T) {
			res = 0; //정답
			N = sc.nextInt(); //햄버거 수
			L = sc.nextInt(); //제한 칼로리
			taste = new int[N]; cal = new int[N]; //배열 생성
			visit = new boolean[N];
			
			//재료값 넣기
			for (int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			find(0);
			
			System.out.println("#" + t + " " + res);
		}
	}
	private static void find(int cnt) {
		if(cnt == N) {
			int tempCal = 0; //칼로리
			int tempVal = 0; //점수
			for (int i = 0; i < N; i++) {
				if(visit[i]) {
					tempCal += cal[i];
					tempVal += taste[i];
				}
			}
			
			//결과값 계산
			if(tempCal <= L) res = Math.max(res, tempVal);
			return;
		}
		
		visit[cnt] = true;
		find(cnt + 1);
		visit[cnt] = false;
		find(cnt + 1);
		
	}

}
