import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, r1, c1, r2, c2, answer = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void bfs() {
        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r1, c1, 0));
        visited[r1][c1] = true;

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = curPoint.x + dx[i];
                int ny = curPoint.y + dy[i];

                if ((nx < 0 || ny < 0 || nx >= n || ny >= n) || visited[nx][ny]) continue;

                if (!visited[nx][ny] && nx == r2 && ny == c2) {
                    answer = Math.min(answer, curPoint.cnt + 1);
                    return;
                }

                visited[nx][ny] = true;
                queue.offer(new Point(nx, ny, curPoint.cnt + 1));
            }
        }
    }

    static class Point {
        int x, y, cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
