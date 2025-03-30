import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] result = new int[2];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0;j < c; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int sheep = 0;
        int wolf = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '#' && !visited[i][j]) { // 울타리가 아닌 경우
                    result[0] = 0;
                    result[1] = 0;

                    int[] section = dfs(i, j);
                    if (section[1] >= section[0]) wolf += section[1];
                    else sheep += section[0];
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    static int[] dfs(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == 'o') result[0]++; // 양인 경우
        if (map[x][y] == 'v') result[1]++; // 늑대인 경우

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if (map[nx][ny] == '#' || visited[nx][ny]) continue;
            dfs(nx, ny);
        }

        return result;
    }

}
