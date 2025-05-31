import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n, answer = 0;
    static int[][] farm;
    static boolean[][] top;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        farm = new int[n][m];
        top = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!top[i][j]) bfs(i, j);
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        ArrayList<Point> topList = new ArrayList<>(); // (x, y)와 인접하면서 같은 높이의 좌표

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if ((nx < 0 || ny < 0 || nx >= n || ny >= m) || visited[nx][ny]) continue;

                if (farm[nx][ny] > farm[cur.x][cur.y]) return; // 현재 지점보다 높은 곳이 있으면 산봉우리 x

                if (farm[nx][ny] == farm[cur.x][cur.y]) { // 현재 지점과 높이가 같은 곳이 있으면 산봉우리
                    queue.offer(new Point(nx, ny));
                    topList.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        for (Point topPoint : topList) {
            top[topPoint.x][topPoint.y] = true;
        }

        answer++;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}