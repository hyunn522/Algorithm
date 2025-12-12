import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph;
    static int[] depths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;

        graph = new ArrayList<>();
        depths = new int[n];
        Arrays.fill(depths, -1);

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

        dfs(r, 0);

        for (int depth : depths) {
            sb.append(depth + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int node, int depth) {
        depths[node] = depth;

        for (int next : graph.get(node)) {
            if (depths[next] == -1) {
                dfs(next, depth + 1);
            }
        }
    }

}