import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, order = 1;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] depths, orders;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;

        graph = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(graph.get(i));
        }

        depths = new int[n];
        orders = new int[n];

        dfs(r, 0);

        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += (long) depths[i] * orders[i];
        }
        System.out.println(answer);
    }

    private static void dfs(int cur, int depth) {
        if (depth == n) {
            return;
        }

        visited[cur] = true;
        depths[cur] = depth;
        orders[cur] = order++;

        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
    }
}