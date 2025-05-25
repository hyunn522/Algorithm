import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, t, answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static final int GRAM_FALSE_IDX = 0;
    static final int GRAM_TRUE_IDX = 1;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2]; // 그람을 가진 경우와 아닌 경우에 대해 경로 구분

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(answer == Integer.MAX_VALUE ? "Fail" : answer);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0, false));
        visited[0][0][GRAM_FALSE_IDX] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.dist > t) continue;

            if (cur.x == n - 1 && cur.y == m - 1) {
                answer = Math.min(answer, cur.dist);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                int gramIdx = cur.afterGram ? GRAM_TRUE_IDX : GRAM_FALSE_IDX;
                if (visited[nx][ny][gramIdx]) continue;

                if (map[nx][ny] == 0 || (map[nx][ny] == 1 && cur.afterGram)) { // 빈 공간이거나, 벽이지만 그람을 갖고 있는 경우 -> 이동 가능
                    visited[nx][ny][gramIdx] = true;
                    queue.offer(new Point(nx, ny, cur.dist + 1, cur.afterGram));
                } else if (map[nx][ny] == 2) { // 그람인 경우 -> 그람 획득 및 이동
                    visited[nx][ny][GRAM_TRUE_IDX] = true;
                    queue.offer(new Point(nx, ny, cur.dist + 1, true));
                }
            }
        }
    }

    static class Point {
        int x, y, dist;
        boolean afterGram;

        Point(int x, int y, int dist, boolean afterGram) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.afterGram = afterGram;
        }
    }
}