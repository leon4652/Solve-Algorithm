
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] memo;
    static final int RGB = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //RGB는 각각 color = {0, 1, 2}로 저장, 배열의 첫 항은 N, 둘째 항은 색상을 나타낸다.
        int N = Integer.parseInt(br.readLine());
        memo = new int[N][RGB];

        //첫 번째 항 채우기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) memo[0][i] = Integer.parseInt(st.nextToken());

        int cnt = 1, color[] = new int[RGB];
        while (cnt < N) {
            //새로운 RGB 색상 입력받기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < RGB; i++) color[i] = Integer.parseInt(st.nextToken());

            memo[cnt][0] = Math.min(memo[cnt - 1][1], memo[cnt - 1][2]) + color[0];
            memo[cnt][1] = Math.min(memo[cnt - 1][0], memo[cnt - 1][2]) + color[1];
            memo[cnt][2] = Math.min(memo[cnt - 1][0], memo[cnt - 1][1]) + color[2];
            cnt++;
        }

        //최저값 출력
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < RGB; i++)  if(res > memo[N - 1][i]) res = memo[N - 1][i];
        System.out.println(res);
    }
}
