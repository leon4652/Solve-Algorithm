
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, result = Integer.MAX_VALUE;
	static int[][] map;
	static List<ChickenHouse> cList = new ArrayList<>(); //치킨 전체 담을 리스트
	static List<House> hList = new ArrayList<>(); //치킨 전체 담을 리스트
	static ChickenHouse[] cArr;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		
		//값 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					hList.add(new House(i, j)); //집 리스트 추가
				}
				
				if(map[i][j] == 2) { //치킨집이라면 좌표 저장하여 배열행
					cList.add(new ChickenHouse(i, j));
				}
			}
		}
		
		//전체 리스트 중 선택된 치킨집 담을 배열 선언
		cArr = new ChickenHouse[M];			
		
		//경우의 수 찾아냄
		comb(0, 0);
		System.out.println(result);
	}
	
	
	private static void comb(int cnt, int start) {
		if(cnt == M) { //기저조건
			
			//뽑힌 치킨집들 기반으로 거리 계산 실행
			int sum = 0;
			for (int i = 0; i < hList.size(); i++) { //전체 집 좌표
				int tempMin = Integer.MAX_VALUE; //거리 담을 임시 값
				for (int j = 0; j < cArr.length; j++) { //뽑힌 치킨집 좌표
					//집 하나당 전체 치킨집 좌표마다 거리 계산해서 작은 값을 찾아냄.
					int nowDist = Math.abs(hList.get(i).c - cArr[j].c) + Math.abs(hList.get(i).r - cArr[j].r);
					tempMin = Math.min(tempMin, nowDist);
				}
				sum += tempMin; //집 하나의 최소 거리 담기
			}

			//그 결과값 중 최소값 담기
			result = Math.min(result, sum);
			return;
		}
		
		for (int i = start; i < cList.size(); i++) {
			cArr[cnt] = cList.get(i);
			comb(cnt + 1, i + 1);
		}
		
	}

	static class ChickenHouse {
		int r, c; //좌표값 저장

		public ChickenHouse(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static class House {
		int r, c; //좌표값 저장
		
		public House(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
