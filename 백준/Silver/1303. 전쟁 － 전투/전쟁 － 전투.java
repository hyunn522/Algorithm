import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int blue = 0, white = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int area = (int) Math.pow(dfs(i, j, map[i][j]), 2);
                    if (map[i][j] == 'W') white += area;
                    else blue += area;
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    static int dfs(int startX, int startY, char c) {
        visited[startX][startY] = true;
        int result = 1;

        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if (nx < 0 || ny < 0 || nx >= m | ny >= n) continue;
            if (!visited[nx][ny] && map[nx][ny] == c) {
                result += dfs(nx, ny, c);
            }
        }

        return result;
    }
}
