import java.io.*;
import java.util.*;

public class Main {

    static final int ROW = 10, COL = 9;

    static int r1, c1, r2, c2, answer = Integer.MAX_VALUE;
    static int[][] map = new int[ROW][COL];
    static boolean[][] visited = new boolean[ROW][COL];
    static int[] dx = {0, 0, 1, -1}; // 우/좌/하/상
    static int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        map[r2][c2] = 1; // 목적지

        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r1, c1, 0}); // x좌표, y좌표, 이동 횟수
        visited[r1][c1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curCnt = cur[2];

            if (curX == r2 && curY == c2) { // 목적지 도착
                answer = curCnt;
                return;
            }

            for (int i = 0; i < 4; i++) { // 처음 총 네 방향
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                for (int j = 0; j < 2; j++) { // 처음 방향당 대각선 두 방향씩
                    int[][] points = new int[3][2]; // 도착지를 포함한 경로
                    points[0] = new int[]{nx, ny};
                    if (i < 2) { // 좌우로 이동 -> 상/하 대각선
                        points[1] = new int[]{nx + dx[2 + j], ny + dy[i]};
                        points[2] = new int[]{nx + 2 * dx[2 + j], ny + 2 * dy[i]};
                    } else { // 상하로 이동 -> 좌/우 대각선
                        points[1] = new int[]{nx + dx[i], ny + dy[j]};
                        points[2] = new int[]{nx + 2 * dx[i], ny + 2 * dy[j]};
                    }

                    boolean isPathPossible = true;
                    for (int p = 0; p < 3; p++) { // 경로가 장기판을 벗어나거나 도착지가 아닌 곳에 기물(0이 아닌 것)이 있으면 해당 경로 건너뜀
                        int px = points[p][0];
                        int py = points[p][1];
                        if ((px < 0 || py < 0 || px >= ROW || py >= COL) || (p < 2 && map[px][py] > 0)) {
                            isPathPossible = false;
                            break;
                        }
                    }

                    if (!isPathPossible) continue;

                    // 가능한 경로에 대해 도착지 큐에 넣기
                    int destX = points[2][0];
                    int destY = points[2][1];
                    if (!visited[destX][destY]) {
                        queue.offer(new int[]{destX, destY, curCnt + 1});
                        visited[destX][destY] = true;
                    }
                }
            }
        }
    }
}