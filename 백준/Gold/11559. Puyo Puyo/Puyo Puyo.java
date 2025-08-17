import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int ROW_NUM = 12;
    static int COL_NUM = 6;
    static char[][] field = new char[ROW_NUM][COL_NUM];
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < ROW_NUM; i++) {
            String input = br.readLine();
            for (int j = 0; j < COL_NUM; j++) {
                field[i][j] = input.charAt(j);
            }
        }

        int answer = 0;
        while (true) {
            visited = new boolean[ROW_NUM][COL_NUM];
            boolean isExploded = false;
            // 연쇄 발생된 좌표들
            boolean[][] futureExploded = new boolean[ROW_NUM][COL_NUM];

            for (int i = 0; i < ROW_NUM; i++) {
                for (int j = 0; j < COL_NUM; j++) {
                    if (field[i][j] == '.' || visited[i][j]) continue;
                    List<int[]> result = bfs(i, j);

                    // 같은 색의 구역 크기가 4 이상이면 연쇄 O
                    if (result.size() >= 4) {
                        isExploded = true;
                        for (int[] p : result) {
                            futureExploded[p[0]][p[1]] = true;
                        }
                    }
                }
            }

            // 연쇄 발생 X -> break
            if (!isExploded) break;

            // 연쇄 발생 O
            for (int i = ROW_NUM - 1; i >= 0; i--) {
                for (int j = 0; j < COL_NUM; j++) {
                    if (futureExploded[i][j]) field[i][j] = '.';
                }
            }

            // 중력으로 떨어지기
            drop();

            answer++;
        }

        System.out.println(answer);
    }

    static List<int[]> bfs(int x, int y) {
        char curColor = field[x][y];

        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> result = new ArrayList<>();
        queue.offer(new int[]{x, y});
        result.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if (nx < 0 || ny < 0 || nx >= ROW_NUM || ny >= COL_NUM) continue;

                if (!visited[nx][ny] && field[nx][ny] == curColor) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    result.add(new int[]{nx, ny});
                }
            }
        }

        return result;
    }

    static void drop() {
        for (int j = 0; j < COL_NUM; j++) {
            int w = ROW_NUM - 1;
            for (int i = ROW_NUM - 1; i >= 0; i--) {
                if (field[i][j] != '.') {
                    char temp = field[i][j];
                    field[i][j] = '.';
                    field[w][j] = temp;
                    w--;
                }
            }
        }
    }
}
