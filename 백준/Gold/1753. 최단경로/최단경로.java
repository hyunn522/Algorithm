import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static List<List<Node>> graph;
    static boolean[] visited;
    static int[] cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine()) - 1;

        graph = new ArrayList<>();
        visited = new boolean[v];
        cost = new int[v];

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, w));
        }

        dijkstra(k);

        for (int c : cost) {
            System.out.println(c == Integer.MAX_VALUE ? "INF" : c);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        cost[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.point;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node node : graph.get(cur)) {
                    if (!visited[node.point] && cost[cur] + node.weight < cost[node.point]) {
                        cost[node.point] = cost[cur] + node.weight;
                        queue.add(new Node(node.point, cost[node.point]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int point, weight;

        Node(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
