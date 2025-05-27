import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, answer = -1;
    static int[] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(new Point(0, 0));
        visited[0] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.idx == n - 1) {
                answer = cur.cnt;
                return;
            }

            for (int i = 1; i <= arr[cur.idx]; i++) {
                if (cur.idx + i < n) {
                    if (!visited[cur.idx + i]) {
                        queue.offer(new Point(cur.idx + i, cur.cnt + 1));
                        visited[cur.idx + i] = true;
                    }
                }
            }
        }
    }

    static class Point {
        int idx, cnt;

        Point(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}