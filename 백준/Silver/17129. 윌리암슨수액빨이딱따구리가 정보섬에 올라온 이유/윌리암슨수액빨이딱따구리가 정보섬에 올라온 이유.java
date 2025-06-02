import java.io.*;
import java.util.*;

public class Main {

    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        int startX = 0, startY = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        if (answer == Integer.MAX_VALUE) {
            System.out.println("NIE");
        } else {
            System.out.println("TAK");
            System.out.println(answer);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0}); // {시작점의 x좌표, 시작점의 y좌표, 시작점으로부터의 거리}
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curDist = cur[2];

            if (map[curX][curY] >= 3) {
                answer = curDist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (!visited[nx][ny] && map[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, curDist + 1});
                }
            }
        }
    }

}