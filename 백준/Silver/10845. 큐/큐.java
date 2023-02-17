
import java.io.*;
import java.util.*;

public class Main {
	static Deque<Integer> q1 = new ArrayDeque<>();
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		while(num-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder(st.nextToken());
			
			
			switch(sb.toString()) {
			case("push"):
				int value = 0;
				if (st.hasMoreTokens()) value = Integer.parseInt(st.nextToken());
				q1.offer(value);
				break;
			
			case("pop"):
				if(q1.isEmpty()) bw.write("-1" + "\n");
				else bw.write(q1.poll() + "\n");
				break;
			
			case("size"):
				bw.write(q1.size() + "\n");
				break;
			
			case("empty"):
				if(q1.isEmpty()) bw.write("1" + "\n");
				else bw.write("0" + "\n");
				break;
			
			case("front"):
				if(q1.isEmpty()) bw.write("-1" + "\n");
				else bw.write(q1.getFirst() + "\n");
				break;
			
			case("back"):
				if(q1.isEmpty()) bw.write("-1" + "\n");
				else bw.write(q1.getLast() + "\n");
			break;	
			
			}
			
		}
		bw.close();
		
	}
}