import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            graph = new int[n];
            visited = new boolean[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                graph[i] = x;
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && bfs(i)) {
                    answer++;
                }
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }

    private static boolean bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int next = graph[cur];

            if (next == start) {
                return true;
            }

            if (!visited[next]) {
                queue.offer(next);
                visited[next] = true;
            }
        }

        return false;
    }
}
