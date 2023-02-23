import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        F = scanner.nextInt(); // 전체 층 수
        S = scanner.nextInt(); // 현재 있는 층
        G = scanner.nextInt(); // 목표 층
        U = scanner.nextInt(); // 위로 U층 이동 가능
        D = scanner.nextInt(); // 아래로 D층 이동 가능

        visited = new boolean[F + 1];
        dist = new int[F + 1];

        int result = bfs(S);
        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        dist[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == G) {
                return dist[cur];
            }

            int next = cur + U;
            if (next <= F && !visited[next]) {
                visited[next] = true;
                dist[next] = dist[cur] + 1;
                queue.add(next);
            }

            next = cur - D;
            if (next >= 1 && !visited[next]) {
                visited[next] = true;
                dist[next] = dist[cur] + 1;
                queue.add(next);
            }
        }

        return -1;
    }
}