import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int a, k, answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[1000001];

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(a, 0));
        visited[a] = true;

        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            int curX = cur.get(0);
            int curCnt = cur.get(1);

            if (curX == k) {
                answer = Math.min(answer, curCnt);
                return;
            }

            for (int nx : new int[]{curX + 1, curX * 2}) {
                if (nx > k) continue;

                if (!visited[nx]) {
                    visited[nx] = true;
                    queue.offer(List.of(nx, curCnt + 1));
                }
            }
        }
    }
}