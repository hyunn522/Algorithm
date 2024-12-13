import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, r;
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int[] order;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        order = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        br.close();

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        
        dfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(order[i]);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        order[node] = ++count;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
