import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> deque = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb;
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb = new StringBuilder(st.nextToken());
			int value = Integer.MAX_VALUE;
			if (st.hasMoreTokens())
				value = Integer.parseInt(st.nextToken());

			switch (sb.toString()) {
			case "push_front":
				deque.addFirst(value);
				break;

			case "push_back":
				deque.addLast(value);
				break;

			case "pop_front":
				if(deque.isEmpty()) bw.write("-1\n");
				else bw.write(deque.pollFirst() + "\n");
				break;

			case "pop_back":
				if(deque.isEmpty()) bw.write("-1\n");
				else bw.write(deque.pollLast() + "\n");
				break;

			case "size":
				bw.write(deque.size() + "\n");
				break;
	
			case "empty":
				if(deque.isEmpty()) bw.write("1\n");
				else bw.write("0\n");
				break;

			case "front":
				if(deque.isEmpty()) bw.write("-1\n");
				else bw.write(deque.peekFirst() + "\n");
				break;

			case "back":
				if(deque.isEmpty()) bw.write("-1\n");
				else bw.write(deque.peekLast() + "\n");
				break;
			}
		}
		
		bw.close();
	}
}
