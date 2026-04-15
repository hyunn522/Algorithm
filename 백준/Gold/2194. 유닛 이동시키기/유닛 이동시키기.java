import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, a, b;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        // 장애물 표시
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken()) - 1;
        int endY = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs(startX, startY, endX, endY));
    }

    private static int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY, 0}); // (x, y, 이동횟수)
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curCnt = cur[2];
            if (curX == endX && curY == endY) {
                return curCnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                int rightEdge = nx + a - 1;
                int bottomEdge = ny + b - 1;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || rightEdge >= n || bottomEdge >= m) {
                    continue;
                }

                boolean isPossible = true;
                for (int x = nx; x <= rightEdge; x++) {
                    for (int y = ny; y <= bottomEdge; y++) {
                        // 장애물
                        if (map[x][y] == 1) {
                            isPossible = false;
                            break;
                        }
                    }
                }

                if (!isPossible) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, curCnt + 1});
                }
            }
        }

        return -1;
    }
}