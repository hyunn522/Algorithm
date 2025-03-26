import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int r, c, k, answer = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0 ; i < r; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = input[j];
            }
        }

        visited[r - 1][0] = true;
        dfs(r - 1, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int startX, int startY, int distance) {
        if (distance > k) return;

        if (distance == k) {
            if (startX == 0 && startY == c - 1) answer++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if (map[nx][ny] == 'T' || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, distance + 1);
            visited[nx][ny] = false;
        }
    }

}
