import java.io.*;
import java.util.*;

public class Main {

    static int n, l, r;
    static int[][] people;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        people = new int[n][n];

        for (int i = 0; i < n ;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                people[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            visited = new boolean[n][n];
            boolean isMoved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<Point> union = getUnion(i, j);
                        if (union.size() > 1) {
                            isMoved = true;
                            int sum = 0;
                            for (Point point : union) {
                                sum += people[point.x][point.y];
                            }
                            for (Point point : union) {
                                people[point.x][point.y] = sum / union.size();
                            }
                        }
                    }
                }
            }

            if (!isMoved) break;
            answer++;
        }

        System.out.println(answer);
    }

    private static List<Point> getUnion(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> result = new ArrayList<>();

        queue.add(new Point(x, y));
        result.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;

                int diff = Math.abs(people[cur.x][cur.y] - people[nx][ny]);
                if (!visited[nx][ny] && diff >= l && diff <= r) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    result.add(new Point(nx, ny));
                }
            }
        }

        return result;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
