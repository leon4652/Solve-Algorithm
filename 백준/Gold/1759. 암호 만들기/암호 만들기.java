
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] numbers, arr;
	static char[] moum = { 'a', 'e', 'i', 'o', 'u' };
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);

		numbers = new char[L];
		comb(0, 0);
		bw.close();
	}

	private static void comb(int cnt, int start) throws IOException {
		
		if (cnt == L) {
			int mCnt = 0;
			//오름차순 여부 확인
			for (int i = 1; i < L; i++) if (numbers[i] < numbers[i - 1]) return;
			
			//모음 여부 확인
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < moum.length; j++) {
					if(numbers[i] == moum[j]) mCnt += 1; //모음 찾았을 경우
				}
			}
			
			if(mCnt == 0 || mCnt > L - 2) return; //모음이 하나도 없거나, 자음이 두개 이하일 경우
				
			for(int k = 0; k < L; k++) bw.write(numbers[k] + "");
			bw.write("\n");
			return;
		}

		for (int i = start; i < C; i++) {
			numbers[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}
	}
}
