import java.io.*;
import java.util.*;

public class Main {

    static int n, m, x;
    static List<Integer>[] map;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[b].add(a);
        }

        x = Integer.parseInt(br.readLine()) - 1;

        bfs();
    }

    private static void bfs() {
        int answer = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            answer++;

            for (int next : map[cur]) {
                if (next < 0 || next >= n) continue;

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        System.out.println(answer);
    }
}