import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

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
            if (!visited[i]) {
                visited[i] = true;
                dfs(graph[i]);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void dfs(List<Integer> g) {
        for (int node : g) {
            if (!visited[node]) {
                visited[node] = true;
                dfs(graph[node]);
            }
        }

    }

}
