import java.io.*;
import java.util.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> lst = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int tab = Integer.parseInt(st.nextToken()) - 1; //N번째 = 선택 n - 1 만큼 멀어짐 
		for (int i = 1; i <= num; i++) {
			lst.add(i);
		}
		
		StringBuilder answer = new StringBuilder("<");
		int idx = 0;
		while(!lst.isEmpty()) {
			idx = idxDown(idx + tab);
			answer.append(lst.get(idx) + ", ");
			lst.remove(idx);
		}
		
		answer.delete(answer.length() - 2, answer.length());
		System.out.print(answer + ">");
	}

	static int idxDown(int idx){
		while(idx >= lst.size()) {
			idx -= lst.size();
		}
		return idx;
	}
}
