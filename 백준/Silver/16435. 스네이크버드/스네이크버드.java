
import java.io.*;
import java.util.*;

public class Main {
	static int snakeLength;
	static List<Integer> fList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int fruitNum = Integer.parseInt(st.nextToken());
		snakeLength = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			fList.add(Integer.parseInt(st.nextToken()));
		}
		
		eat(); //메인 메서드
		
		System.out.println(snakeLength);
	}
	
	static void eat() {
		int cnt = 0;
		while(true) {
			if(cnt >= fList.size()) break;
			
			if (fList.get(cnt) <= snakeLength) {
				snakeLength++;
				fList.remove(cnt);
				cnt = 0; //처음으로 돌아감
				continue;
			}
			cnt++;
		}
	}
}
