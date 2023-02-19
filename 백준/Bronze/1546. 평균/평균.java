
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int cnt = 0;
        int Max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            arr[cnt] = Integer.parseInt(st.nextToken());
            Max = Math.max(Max, arr[cnt]);
            cnt++;
        }

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += ((double)arr[i] / Max) * 100;
        }
        sum /= num;

        System.out.println(sum);
    }
}

