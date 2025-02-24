import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        br.close();

        bfs();

        System.out.println(result);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.x == n - 1 && now.y == m - 1) {
                result = now.distance;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (map[nx][ny] == 0 && !visited[nx][ny][now.crush]) { // 벽이 아닌 경우
                    visited[nx][ny][now.crush] = true;
                    queue.offer(new Point(nx, ny, now.distance + 1, now.crush));
                } else { // 벽인 경우
                    if (now.crush == 0 && !visited[nx][ny][now.crush + 1]) { // 벽을 부순 적이 없는 경우
                        visited[nx][ny][now.crush + 1] = true;
                        queue.offer(new Point(nx, ny, now.distance + 1, now.crush + 1));
                    }
                }
            }
        }

    }

    static class Point {
        int x, y, distance, crush; // crush = 현재까지 부순 벽의 개수

        Point(int x, int y, int distance, int crush) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.crush = crush;
        }
    }

}
