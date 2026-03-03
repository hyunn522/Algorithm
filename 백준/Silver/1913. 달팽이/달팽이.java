import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 큰 숫자부터 채우기 -> 반시계 방향으로 회전
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] map = new int[n][n];
        int d = 0;
        int x = 0;
        int y = 0;
        int answerX = -1;
        int answerY = -1;

        for (int i = n * n; i >= 1; i--) {
            map[x][y] = i;
            if (i == m) {
                answerX = x;
                answerY = y;
            }

            int nx = x + dx[d];
            int ny = y + dy[d];

            // 막히면 방향 꺾기
            if ((nx < 0 || ny < 0 || nx >= n || ny >= n) || map[nx][ny] != 0) {
                d = (d + 1) % 4;
            }

            // 다음 좌표 갱신
            x += dx[d];
            y += dy[d];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append((answerX + 1) + " " + (answerY + 1));
        System.out.println(sb);
    }
}
