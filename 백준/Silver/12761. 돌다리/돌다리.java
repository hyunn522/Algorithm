import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int a, b, n, m, answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            int curX = cur.get(0);
            int curCnt = cur.get(1);

            if (curX == m) {
                answer = Math.min(answer, curCnt);
                return;
            }

            for (int nx : new int[]{curX + 1, curX - 1, curX + a, curX + b, curX - a, curX - b, curX * a, curX * b}) {
                if (nx < 0 || nx > 100000) continue;

                if (!visited[nx]) {
                    visited[nx] = true;
                    queue.offer(List.of(nx, curCnt + 1));
                }
            }
        }
    }
}