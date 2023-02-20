
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());
		pos[] arr = new pos[num];
		
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i].x + " " + arr[i].y + "\n");
		}
		bw.close();
		
	}
	
	static class pos implements Comparable<pos> {
		int x = 0;
		int y = 0;
		
		pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(pos o) {
			if(y == o.y) return x - o.x;
			return y - o.y;
		}


	}
}