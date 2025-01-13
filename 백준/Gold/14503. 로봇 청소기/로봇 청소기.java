import java.io.*;
import java.util.StringTokenizer;

public class Main {

    /*
    0 = 아직 청소되지 않음, 1 = 벽, 2 = 청소됨
     */
    private static int n, m, d;
    private static int[][] room;
    // 북, 동, 남, 서
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c);

        System.out.println(result);
    }

    private static void clean(int r, int c) {
        // 현재 칸이 청소되지 않은 경우
        if (room[r][c] == 0) {
            room[r][c] = 2;
            result++;
        }

        // 현재 칸의 동서남북 청소
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4; // 반시계 방향으로 회전
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m && room[nr][nc] == 0) {
                clean(nr, nc);
                return;
            }
        }

        // 현재 칸의 동서남북이 모두 청소된 경우
        int backD = (d + 2) % 4;
        int nr = r + dr[backD];
        int nc = c + dc[backD];
        if (nr >= 0 && nc >= 0 && nr < n && nc < m && room[nr][nc] != 1) {
            clean(nr, nc);
        }
    }
}
