import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m, x, y, k;
    static int[][] map;
    static int[] dice = new int[6]; // top, bottom, north, south, east, west
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken()) - 1;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            x = nx;
            y = ny;

            roll(dir);
            if (map[x][y] == 0) {
                // 주사위의 바닥면 -> map에 복사
                map[x][y] = dice[1];
            } else {
                // map -> 주사위의 바닥면에 복사, map에는 0
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dice[0] + "\n");
        }

        System.out.println(sb);
    }

    private static void roll(int dir) {
        int top = dice[0];
        int bottom = dice[1];
        int north = dice[2];
        int south = dice[3];
        int east = dice[4];
        int west = dice[5];

        if (dir == 0) { // 동쪽으로 회전
            dice[0] = west;
            dice[1] = east;
            dice[4] = top;
            dice[5] = bottom;
        } else if (dir == 1) { // 서쪽으로 회전
            dice[0] = east;
            dice[1] = west;
            dice[4] = bottom;
            dice[5] = top;
        } else if (dir == 2) { // 북쪽으로 회전
            dice[0] = south;
            dice[1] = north;
            dice[2] = top;
            dice[3] = bottom;
        } else if (dir == 3) { // 남쪽으로 회전
            dice[0] = north;
            dice[1] = south;
            dice[2] = bottom;
            dice[3] = top;
        }
    }
}
