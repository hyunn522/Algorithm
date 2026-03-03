import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 시계 방향으로 회전
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] map = new int[n][n];
        int x = n / 2;
        int y = n / 2;
        int answerX = -1;
        int answerY = -1;

        int curN = 1;
        int curIdx = 1; // 각 묶음별로 2번씩 나아가야 함
        int totalCnt = 1; // 이번 방향에서 총 나아가야 할 횟수
        int cnt = 0; // 이번 방향에서 나아간 횟수
        int d = 0;

        map[x][y] = curN;
        if (curN == m) {
            answerX = x;
            answerY = y;
        }

        while (curN < n * n) {
            // 이동 먼저
            x += dx[d];
            y += dy[d];

            curN++;
            map[x][y] = curN;
            if (curN == m) {
                answerX = x;
                answerY = y;
            }

            cnt++;

            // 이번 방향 다 나아갔으면 방향 전환
            if (cnt == totalCnt) {
                d = (d + 1) % 4;
                cnt = 0;
                if (curIdx == 2) {
                    // 이번 묶음 끝난 경우
                    totalCnt++;
                    curIdx = 1;
                } else {
                    curIdx++;
                }
            }
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
