import java.util.*;

//백트래킹 사용
//단순 생각하면 완전탐색을 수행할 경우 6 * 6 * 6.. 6^100의 경우의 수가 생긴다.
//해당 좌표에 이전 최소 값을 비교하여 이보다 높은 연산일 경우 제거하는 기저조건을 추가하였음.

public class Main {
	static Scanner sc = new Scanner(System.in);
	final static int DICE = 6;
	final static int SIZE = 100;
	final static int INF = Integer.MAX_VALUE;
	static int[] map = new int[SIZE + 1];
	
	static int N, M;
	static int[][] ladders, snakes;
	
	static int res = INF;
	
	public static void main(String[] args) {
		for (int i = 0; i < SIZE + 1; i++) map[i] = INF;
		N = sc.nextInt();
		M = sc.nextInt();
		ladders = new int[N][2];
		snakes = new int[M][2];

		for (int i = 0; i < N; i++) {
			ladders[i][0] = sc.nextInt();
			ladders[i][1] = sc.nextInt();
		}
		for (int i = 0; i < M; i++) {
			snakes[i][0] = sc.nextInt();
			snakes[i][1] = sc.nextInt();
		}
		
		//주사위 굴리기
		for (int i = 1; i <= DICE; i++) {
			move(1 + i, 1);
		}
		
		System.out.println(res);
	}
	
	private static void move(int now, int cnt) {
		if(now >= SIZE) { //1. 기저조건
			if(now == SIZE) { //도착
				res = Math.min(res, cnt);
			}
			return;
		}
		
		//2. 기저조건 2
		if(cnt >= map[now]) return;
		map[now] = cnt;
		
		//3. 사다리나 뱀을 만났을 경우 해당 칸으로 이동
		if(visitLadderOrSnake(now, cnt)) return;
		
		//4. 다음 주사위 굴리기
		for (int i = 1; i <= DICE; i++) {
			move(now + i, cnt + 1); 
		}
	}

	private static boolean visitLadderOrSnake(int now, int cnt) {
		//1. 사다리
		for (int i = 0; i < N; i++) {
			if(ladders[i][0] == now) {
				move(ladders[i][1] , cnt);
				return true;
			}
		}
		//2. 뱀
		for (int i = 0; i < M; i++) {
			if(snakes[i][0] == now) {
				move(snakes[i][1] , cnt);
				return true;
			}
		}
		
		return false;
	}


	
}
