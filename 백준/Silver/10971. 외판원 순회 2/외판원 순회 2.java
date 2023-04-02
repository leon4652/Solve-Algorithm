import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, min, map[][];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;

            find(i, i, 0, 0);
        }

        System.out.println(min);
    }

    private static void find(int start, int now, int sum, int cnt) {
        //기저조건 : 자신 제외한 모든 경로 탐색
        if(cnt == N - 1) {
            if(map[now][start] != 0) {
                sum += map[now][start];
                min = Math.min(sum, min);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            //기저조건
            if(visited[i] || map[now][i] == 0) continue;
            visited[i] = true;
            find(start, i, sum + map[now][i], cnt + 1);
            visited[i] = false;
        }
    }
}