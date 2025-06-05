import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<int[]>[] graph;
    static boolean[] visited;
    static long maxDistance = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        visited[1] = true;
        dfs(1, 0);
        System.out.println(maxDistance);
    }

    static void dfs(int current, long distance) {
        maxDistance = Math.max(maxDistance, distance);

        for (int[] neighbor : graph[current]) {
            int next = neighbor[0];
            int weight = neighbor[1];
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, distance + weight);
            }
        }
    }
}
