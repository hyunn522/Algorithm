import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] maze;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0;j < m; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(input[j]));
            }
        }

        bfs(0, 0);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0;j < m; j++) {
//                if (!isVisited[i][j] && maze[i][j] == 1) {
//                    bfs(i, j);
//                }
//            }
//        }
        sb.append(result);

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            x = node[0];
            y = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (!isVisited[nx][ny] && maze[nx][ny] == 1) {
                    isVisited[nx][ny] = true;
                    maze[nx][ny] = maze[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        result = maze[n - 1][m - 1];
    }
}
