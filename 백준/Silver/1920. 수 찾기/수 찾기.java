import java.io.*;
import java.util.*;

public class Main {
	static int[] arrA;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arrA = setting(Integer.parseInt(br.readLine()), new StringTokenizer(br.readLine()));
				
		int trash = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			findIt(Integer.parseInt(st.nextToken()), 0, arrA.length - 1);

		}
		
		bw.close();
	}
	
	
	private static void findIt(int n, int min, int max) throws IOException {
		if(min > max) {
			bw.write("0\n");
			return;
		}
		
		int mid = (min + max) / 2;
		if(arrA[mid] == n) {
			bw.write("1\n");

		}
		else if (arrA[mid] < n) findIt(n, mid + 1, max);
		else findIt(n, 0, mid - 1); //(arrA[mid] > n)
		
		return;
	}


	static int[] setting(int num, StringTokenizer st) {
		int arr[] = new int[num];
		int cnt = 0;
		while(st.hasMoreElements()) {
			arr[cnt++] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		return arr;
	}
}