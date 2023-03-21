
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return (int)o2 - (int)o1;
			}
		});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		while(n-- > 0) {
			int temp = Integer.parseInt(br.readLine());
			if(temp == 0) {
				if(pq.isEmpty()) bw.write("0\n");
				else bw.write(pq.remove() + "\n");
			} else pq.offer(temp);
		}
		
		bw.close();
	}

}
