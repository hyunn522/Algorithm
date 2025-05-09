import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, q, k, v;
    static List<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()) - 1;
            int q = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken());

            graph[p].add(new Node(q, r));
            graph[q].add(new Node(p, r));
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken()) - 1;
            visited = new boolean[n];
            sb.append(bfs() + "\n");
        }

        System.out.println(sb);
    }

    private static int bfs() {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Node next : graph[cur]) {
                if (!visited[next.x] && next.cost >= k) {
                    visited[next.x] = true;
                    queue.offer(next.x);
                    result++;
                }
            }
        }

        return result;
    }

    static class Node {
        int x, cost;

        Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
}
