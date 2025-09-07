import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int k, w, h;
    static int[][] map;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] horseDx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] horseDy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        boolean[][][] visited = new boolean[h][w][k + 1]; // 말 이동 유무
        Queue<int[]> queue = new LinkedList<>(); // {현재 x좌표, 현재 y좌표, 말 이동 횟수, 전체 이동 횟수}
        queue.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            int curHorseCnt = cur[2];
            int curCnt = cur[3];

            if (curY == h - 1 && curX == w - 1) {
                return curCnt;
            }

            // 말 이동
            if (curHorseCnt < k) {
                for (int hd = 0; hd < 8; hd++) {
                    int ny = curY + horseDy[hd];
                    int nx = curX + horseDx[hd];

                    if ((ny < 0 || nx < 0 || ny >= h || nx >= w) || visited[ny][nx][curHorseCnt + 1]
                            || map[ny][nx] == 1) {
                        continue;
                    }

                    visited[ny][nx][curHorseCnt + 1] = true;
                    queue.offer(new int[]{ny, nx, curHorseCnt + 1, curCnt + 1});
                }
            }

            // 원숭이 이동
            for (int d = 0; d < 4; d++) {
                int ny = curY + dy[d];
                int nx = curX + dx[d];

                if ((ny < 0 || nx < 0 || ny >= h || nx >= w) || visited[ny][nx][curHorseCnt] || map[ny][nx] == 1) {
                    continue;
                }

                visited[ny][nx][curHorseCnt] = true;
                queue.offer(new int[]{ny, nx, curHorseCnt, curCnt + 1});
            }
        }

        return -1;
    }
}
