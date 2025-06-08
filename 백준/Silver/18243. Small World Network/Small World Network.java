import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            if (!bfs(i)) {
                System.out.println("Big World!");
                return;
            }
        }

        System.out.println("Small World!");
    }

    private static boolean bfs(int start) {
        visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curNode = cur[0];
            int curDepth = cur[1];

            if (curDepth > 6) return false;

            for (int nextNode : graph[curNode]) {
                if (!visited[nextNode]) {
                    queue.offer(new int[]{nextNode, curDepth + 1});
                    visited[nextNode] = true;
                }
            }
        }

        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }
}