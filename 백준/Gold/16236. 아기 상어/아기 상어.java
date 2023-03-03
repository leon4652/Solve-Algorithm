
import java.util.*;
import java.io.*;

public class Main {
	static int N, res = 0;
	static int[][] map;
	static boolean[][] visit;
	static Shark baby = new Shark(-1, -1, 2, 0); //상어 설정
	static Queue<int[]> q = new ArrayDeque<>(); // R / C / 시간
	static PriorityQueue<int[]> fish = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[2] == o2[2]) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1]; //가장 왼쪽에 있는 물고기
				}
				return o1[0] - o2[0]; //가장 위에 있는 물고기
			}
			return o1[2] - o2[2]; //가장 가까운 물고기
		}
		
	});
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					baby.r = i;
					baby.c = j;
					map[i][j] = 0; //초기화
				}
			}
		}
		
		while(true) {
		bfs();	//먹이 탐색
		if(fish.size() == 0) break; //상어가 먹을 수 있는 먹이가 없음
		
		int temp[] = fish.poll(); 	//먹을 물고기 저장한 값 (R, C, Time)
		
		res += temp[2]; //시간 저장
		baby.r = temp[0];
		baby.c = temp[1]; //좌표 갱신
		baby.eat();
		
		map[baby.r][baby.c] = 0; 	//자리 초기화
		q.clear(); 				   	//큐 초기화
		fish.clear();				//
		visit = new boolean[N][N]; 	//방문 초기화
		
		}
		
		System.out.println(res);
	}
	
	static void bfs() {
		q.offer(new int[] {baby.r, baby.c, 0}); //상어가 가까운 먹이를 탐색
		
		while(!q.isEmpty()) {
			int[][] shift = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; //U L R D
			int temp[] = q.poll(); //임시 값 빼오기
			int r = temp[0];
			int c = temp[1];
			int time = temp[2];
			
			//기저조건 : 작은 물고기를 발견했을 경우 fish Queue에 추가
			if (map[r][c] != 0 && baby.size > map[r][c]) {
				fish.offer(new int[] {r, c, time});
			}
			
			for (int i = 0; i < shift.length; i++) {
				int nr = r + shift[i][0];
				int nc = c + shift[i][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] > baby.size) continue;
				visit[nr][nc] = true; //방문 처리
				q.offer(new int[] {nr, nc, time + 1});
			}
		}
	}
	
	static class Shark {
		int r, c; //좌표
		int size, eat; //크기, 현재 먹은 횟수
		
		public Shark(int r, int c, int size, int eat) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.eat = eat;
		}
		
		void eat() {
			eat += 1;
			if (size == eat) {
				eat = 0;
				size += 1;
			}
		}
	}
}
