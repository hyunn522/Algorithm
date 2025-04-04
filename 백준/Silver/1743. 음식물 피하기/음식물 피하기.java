import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = true;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] && !visited[i][j]) {
                    result = Math.max(result, dfs(i, j));
                }
            }
        }

        System.out.println(result);
    }

    static int dfs(int startX, int startY) {
        visited[startX][startY] = true;
        int result = 1;

        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if (nx < 0 || ny < 0 || nx >= n | ny >= m) continue;
            if (!visited[nx][ny] && map[nx][ny]) {
                result += dfs(nx, ny);
            }
        }

        return result;
    }
}
