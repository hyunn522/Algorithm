import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m, d, answer = 0;
    static int[][] room; // 0 : 벽, 1 : 청소되지 않은 빈 칸, 2 : 청소된 빈 칸
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

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

        System.out.println(answer);
    }

    private static void clean(int x, int y) {
        // 현재 칸이 청소되어 있지 않은 경우
        if (room[x][y] == 0) {
            room[x][y] = 2;
            answer++;
        }

        // 주변 4칸 청소
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4; // 반시계 방향으로 90도 회전
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && room[nx][ny] == 0) {
                clean(nx, ny);
                return;
            }
        }

        // 주변 4칸이 이미 청소되어있는 경우 방향 유지하며 후진
        int nx = x + dx[(d + 2) % 4];
        int ny = y + dy[(d + 2) % 4];
        if (nx >= 0 && ny >= 0 && nx < n && ny < m && room[nx][ny] != 1) {
            clean(nx, ny);
        }
    }
}