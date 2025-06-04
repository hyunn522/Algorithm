import java.io.*;
import java.util.*;

public class Main {

    static int n, m, r;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        bfs();

        System.out.println(sb);
    }

    private static void bfs() {
        int[] depth = new int[n];
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        visited[r] = true;
        queue.offer(new int[]{r, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curNode = cur[0];
            int curDepth = cur[1];
            depth[curNode] = curDepth;

            for (int nextNode : graph[curNode]) {
                if (!visited[nextNode]) {
                    queue.offer(new int[]{nextNode, curDepth + 1});
                    visited[nextNode] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(!visited[i] ? -1 : depth[i]).append("\n");
        }
    }
}