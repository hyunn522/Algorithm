import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] graph;
    private static boolean[] visited;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            graph[c1][c2] = 1;
            graph[c2][c1] = 1;
        }
        br.close();

        for (int i = 1; i <= n; i++) {
            graph[i][i] = 1;
        }

        dfs(1);

        System.out.println(result);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                dfs(i);
                result++;
            }
        }
    }
}
