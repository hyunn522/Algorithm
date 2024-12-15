import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    private static int n, m, v;
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int order = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1 ; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);

        visited = new boolean[n + 1];
        order = 0;
        sb.append("\n");

        bfs(v);

        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int node : graph[start]) {
            if (!visited[node]) dfs(node);
        }
    }

    private static void bfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int nx : graph[node]) {
                if (!visited[nx]) {
                    visited[nx] = true;
                    queue.offer(nx);
                    sb.append(nx).append(" ");
                }
            }
        }

    }

}
