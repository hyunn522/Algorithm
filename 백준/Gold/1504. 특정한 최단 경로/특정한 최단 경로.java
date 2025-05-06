import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, e, v1, v2;
    static int[][] graph;
    static int[] dist;
    static final int MAX_VALUE = 200000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        dist = new int[n]; // 시작점에서 각 정점까지의 최단 거리

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], MAX_VALUE);
            graph[i][i] = 0;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
            graph[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken()) - 1;
        v2 = Integer.parseInt(st.nextToken()) - 1;

        // case 1) 1 -> v1 + v1 -> v2 + v2 -> n
        int d1 = dijkstra(0, v1) + dijkstra(v1, v2) + dijkstra(v2, n - 1);
        // case 2) 1 -> v2 + v2 -> v1 -> v1 -> n
        int d2 = dijkstra(0, v2) + dijkstra(v2, v1) + dijkstra(v1, n - 1);

        System.out.println(Math.min(d1, d2) >= MAX_VALUE ? -1 : Math.min(d1, d2));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, MAX_VALUE);

        pq.add(new Node(start, 0));
        visited[start] = true;
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            visited[curNode.x] = true;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[curNode.x] + graph[curNode.x][i] < dist[i]) {
                    dist[i] = dist[curNode.x] + graph[curNode.x][i];
                    pq.add(new Node(i, dist[i]));
                }
            }
        }

        return dist[end];
    }

    static class Node implements Comparable<Node>{
        int x, cost;

        Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

}
