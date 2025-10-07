import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        // 대륙 따로 넘버링하기 위해 -1로 마스킹
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? -1 : 0;
            }
        }

        // 각 대륙 표시
        int landIdx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == -1) {
                    markLands(i, j, landIdx++);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && isEdge(i, j)) {
                    // 각 대륙의 가장자리에서 사방으로 탐색 후 가장 가까운 다른 대륙 찾아가기
                    findShortestPath(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void markLands(int x, int y, int landIdx) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = landIdx;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] == -1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    map[nx][ny] = landIdx;
                }
            }
        }
    }

    private static boolean isEdge(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            if (map[nx][ny] == 0) {
                return true;
            }
        }

        return false;
    }

    private static void findShortestPath(int x, int y) {
        int curLand = map[x][y];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 0});
        visited = new boolean[n][n];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curDist = cur[2];

            // 지금까지 구했던 최단 거리보다 큰 경우 더 이상 보지 않음
            if (curDist > answer) {
                continue;
            }

            // 새로운 대륙 도착
            if (map[curX][curY] != 0 && map[curX][curY] != curLand) {
                answer = curDist - 1;
            }

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] != curLand) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, curDist + 1});
                }
            }
        }
    }
}
