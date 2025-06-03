import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        graph = new int[26];
        Arrays.fill(graph, -1);

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int b = st.nextToken().charAt(0) - 'a';
            graph[a] = b;
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int b = st.nextToken().charAt(0) - 'a';

            bfs(a, b);
        }

        System.out.println(sb);
    }

    private static void bfs(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        boolean[] visited = new boolean[26];
        visited[a] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == b) {
                sb.append("T\n");
                return;
            }

            int next = graph[cur];
            if (next != -1 && !visited[next]) {
                queue.offer(next);
                visited[next] = true;
            }
        }

        sb.append("F\n");
    }
}