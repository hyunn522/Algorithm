import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m, globalMax = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
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
                globalMax = Math.max(globalMax, map[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        if (sum + globalMax * (4 - depth) <= answer) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((nx < 0 || ny < 0 || nx >= n || ny >= m) || visited[nx][ny]) {
                continue;
            }

            // T 모양 처리
            if (depth == 2) {
                visited[nx][ny] = true;
                dfs(x, y, sum + map[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, sum + map[nx][ny], depth + 1);
            visited[nx][ny] = false;
        }
    }
}
