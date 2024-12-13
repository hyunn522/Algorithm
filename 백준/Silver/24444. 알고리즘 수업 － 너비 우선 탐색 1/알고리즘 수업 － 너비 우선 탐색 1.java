import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, r;
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int[] visitOrder;
    private static int order = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        visitOrder = new int[n + 1];

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

        bfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(visitOrder[i]);
        }
    }

    private static void bfs(int start) {
        visited[start] = true;
        visitOrder[start] = ++order;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int nx : graph[node]) {
                if (!visited[nx]) {
                    visited[nx] = true;
                    visitOrder[nx] = ++order;
                    queue.offer(nx);
                }
            }
        }

    }

}
