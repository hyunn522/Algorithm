import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, answer = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j + 1] = line.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n + 1][m + 1][11]; // x좌표, y좌표, 현재까지 부순 벽의 개수
        queue.offer(new int[]{1, 1, 1, 0, 1}); // x좌표, y좌표, 칸 수, 현재까지 부순 벽의 개수, 밤낮(0 : 밤, 1 : 낮)
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curCnt = cur[2];
            int curBreak = cur[3];
            int curDay = cur[4];

            if (curX == n && curY == m) {
                answer = Math.min(answer, curCnt);
            }

            int nextBreak = curBreak + 1;
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > m) {
                    continue;
                }

                if (map[nx][ny] == 1) { // 벽인 경우
                    // 부술 기회 없음
                    if (curBreak == k) {
                        continue;
                    }

                    // 밤이면 머물기
                    if (curDay == 0) {
                        queue.offer(new int[]{curX, curY, curCnt + 1, curBreak, (curDay + 1) % 2});
                        continue;
                    }

                    // 부수면서 이동
                    if (!visited[nx][ny][nextBreak]) {
                        queue.offer(new int[]{nx, ny, curCnt + 1, nextBreak, (curDay + 1) % 2});
                        visited[nx][ny][nextBreak] = true;
                    }
                } else { // 벽이 아닌 경우
                    if (!visited[nx][ny][curBreak]) {
                        queue.offer(new int[]{nx, ny, curCnt + 1, curBreak, (curDay + 1) % 2});
                        visited[nx][ny][curBreak] = true;
                    }
                }
            }
        }
    }
}