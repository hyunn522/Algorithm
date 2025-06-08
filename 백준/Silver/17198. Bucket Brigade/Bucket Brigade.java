import java.io.*;
import java.util.*;

public class Main {

    static final int SIZE = 10;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[SIZE][SIZE];
        boolean[][] visited = new boolean[SIZE][SIZE];

        int startX = -1, startY = -1;
        for (int i = 0; i < SIZE; i++) {
            String input = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'B') {
                    startX = i;
                    startY = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curCnt = cur[2];

            if (map[curX][curY] == 'L') {
                System.out.println(curCnt - 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;

                if (!visited[nx][ny] && map[nx][ny] != 'R') {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, curCnt + 1});
                }
            }
        }
    }
}