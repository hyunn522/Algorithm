import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int result = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); // x 좌표, y 좌표, 이동한 격자 개수

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curCnt = cur[2];

            if (curX == n - 1 && curY == m - 1) {
                result = Math.min(result, curCnt);
            }

            for (int i = 1; i <= map[curX][curY]; i++) {
                for (int j = 0; j < 2; j++) {
                    int nx = curX + i * dx[j];
                    int ny = curY + i * dy[j];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, curCnt + 1});
                    }
                }
            }
        }

        return result;
    }
}