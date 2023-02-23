import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N, B, C;
	static int room[];
	static long res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		room = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		while(st.hasMoreTokens()) {
			room[cnt++] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());		
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		//입력값 처리 완료
		res = room.length; //각 시험장마다 총 감독관은 있어야 함.
		
		cnt = 0;
		while(cnt < room.length) {
			int stu = room[cnt++] - B; 	//시험장에 추가적으로 감독관이 필요한 학생 수
			if(stu <= 0) continue; 	   	//필요 없으면 패스
			res += stu / C;				//필요한만큼 추가
			if(stu % C != 0) res += 1;
		}
		
		System.out.println(res);
	}
}
