import java.util.*;

public class Main {
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // 정점의 개수
        int E = sc.nextInt(); // 간선의 개수
        int start = sc.nextInt(); // 시작 정점 번호

        List<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(); // 시작 정점
            int v = sc.nextInt(); // 도착 정점
            int w = sc.nextInt(); // 가중치

            graph[u].add(new Edge(v, w));
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 최소힙
        pq.offer(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (curDist > dist[curNode]) { // 최단 경로가 아닌 경우 스킵
                continue;
            }

            for (Edge e : graph[curNode]) {
                int nextNode = e.to;
                int nextDist = curDist + e.weight;

                if (nextDist < dist[nextNode]) { // 최단 경로 갱신
                    dist[nextNode] = nextDist;
                    pq.offer(new int[] { nextNode, nextDist });
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}