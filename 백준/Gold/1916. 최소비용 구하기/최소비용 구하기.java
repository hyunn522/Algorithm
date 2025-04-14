import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int n, m;
    static List<List<Node>> bus;
    static int[] costs;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        bus = new ArrayList<>();
        visited = new boolean[n];
        costs = new int[n];

        Arrays.fill(costs, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            bus.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            bus.get(a).add(new Node(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        dijkstra(start, end);

        System.out.println(costs[end]);
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        costs[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node next : bus.get(cur)) {
                    if (!visited[next.end] && costs[cur] + next.cost < costs[next.end]) {
                        costs[next.end] = costs[cur] + next.cost;
                        queue.add(new Node(next.end, costs[next.end]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end, cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
