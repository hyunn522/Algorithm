import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] points = new int[25][2]; // 각 숫자가 놓여진 좌표를 저장
        boolean[][] visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(st.nextToken());
                points[n - 1][0] = i;
                points[n - 1][1] = j;
            }
        }

        int answer = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int cur = Integer.parseInt(st.nextToken()) - 1;

                // cur의 위치 파악
                int x = points[cur][0];
                int y = points[cur][1];

                // visited 갱신
                visited[x][y] = true;
                answer++;

                // 완성된 줄 개수 세기
                int bingoCount = 0;

                // 가로 5줄
                for (int r = 0; r < 5; r++) {
                    if (visited[r][0] && visited[r][1] && visited[r][2] && visited[r][3] && visited[r][4]) {
                        bingoCount++;
                    }
                }

                // 세로 5줄
                for (int c = 0; c < 5; c++) {
                    if (visited[0][c] && visited[1][c] && visited[2][c] && visited[3][c] && visited[4][c]) {
                        bingoCount++;
                    }
                }

                // 대각선 2줄
                if (visited[0][0] && visited[1][1] && visited[2][2] && visited[3][3] && visited[4][4]) {
                    bingoCount++;
                }
                if (visited[0][4] && visited[1][3] && visited[2][2] && visited[3][1] && visited[4][0]) {
                    bingoCount++;
                }

                if (bingoCount >= 3) {
                    System.out.println(answer);
                    return;
                }
            }
        }
    }
}
