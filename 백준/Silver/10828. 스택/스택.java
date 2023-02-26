
import java.io.*;
import java.util.*;

public class Main {
	static Stack<Integer> s1 = new Stack<>();
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		while(num-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder(st.nextToken());
			int value = 0;
			if(st.hasMoreTokens()) value = Integer.parseInt(st.nextToken());
			
			
			switch(sb.toString()) {
			case("push"):
				s1.add(value);
				break;
			
			case("pop"):
				if(s1.isEmpty()) bw.write("-1\n");
				else bw.write(s1.pop() + "\n");
				break;
			
			case("size"):
				bw.write(s1.size() + "\n");
				break;
			
			case("empty"):
				if(s1.isEmpty()) bw.write("1\n");
				else bw.write("0\n");
				break;
			
			case("top"):
				if(s1.isEmpty()) bw.write("-1\n");
				else bw.write(s1.peek() + "\n");
				break;
			
			}
			
		}
		bw.close();
		
	}
}