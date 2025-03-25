import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, max = 0;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        result = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            if (!graph[i].isEmpty()) {
                visited = new boolean[n + 1];
                Queue<Integer> queue = new LinkedList<>();

                visited[i] = true;
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int current = queue.poll();

                    for (int next : graph[current]) {
                        if (!visited[next]) {
                            max = Math.max(max, ++result[next]);
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == max) System.out.print(i + " ");
        }
    }

}
