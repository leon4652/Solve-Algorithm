
import java.util.*;
import java.io.*;

public class Main {
	static long d[] = new long[1000 + 1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		d[1] = 1;
		d[2] = 2;
		
		for (int i = 3; i < (1000 + 1); i++) {
			d[i] = (d[i - 2] + d[i - 1]) % 10007;
		}
		
		System.out.println(d[N]);
	}

}
