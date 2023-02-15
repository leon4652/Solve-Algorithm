
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		 
		List<Integer> l = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) l.add(i + 1);
		
		int cnt = N;
		int arr[] = new int[N];
		int idx = K - 1;
		while(cnt > 0) {
			if(idx >= l.size()) idx = idx % l.size();
			
			arr[N - cnt] = l.get(idx);
			l.remove(idx);
			idx += K - 1;
			
			cnt--;
		}
		
		System.out.print("<");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length - 1] + ">");
		
	}

}
