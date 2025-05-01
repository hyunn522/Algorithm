import java.io.*;
import java.util.*;

public class Main {

    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new char[w][h];

        for (int i = 0; i < w; i++) {
            String input = br.readLine();
            for (int j = 0; j < h; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (map[i][j] == 'L') bfs(i, j);
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        visited = new boolean[w][h];
        int result = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, 0));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            result = cur.dist;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;

                if (map[nx][ny] == 'W' || visited[nx][ny]) continue;

                queue.offer(new Point(nx, ny, cur.dist + 1));
                visited[nx][ny] = true;
            }
        }

        answer = Math.max(answer, result);
    }

    static class Point {
        int x, y, dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
