import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int a, b, n, m, answer = Integer.MAX_VALUE;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()) - 1;
        b = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new List[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            graph[x].add(y);
            graph[y].add(x);
        }

        bfs();

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void bfs() {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(a, 0));
        visited[a] = true;

        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            int curX = cur.get(0);
            int curCnt = cur.get(1);

            if (curX == b) {
                answer = Math.min(answer, curCnt);
            }

            for (int next : graph[curX]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(List.of(next, curCnt + 1));
                }
            }
        }
    }
}