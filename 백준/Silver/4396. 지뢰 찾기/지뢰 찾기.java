import java.io.*;

public class Main {

    static char[][] bomb, board;
    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        bomb = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                bomb[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        boolean isBomb = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'x') {
                    // 지뢰가 있는 칸이 열림 -> 지뢰는 모두 *
                    if (bomb[i][j] == '*') {
                        isBomb = true;
                    }

                    // 지뢰가 없는 칸이 열림 -> 주위 8칸 중 지뢰의 개수 세기
                    int cnt = 0;
                    for (int d = 0; d < 8; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                            continue;
                        }

                        if (bomb[nx][ny] == '*') {
                            cnt++;
                        }
                    }
                    board[i][j] = (char) ('0' + cnt);
                }
            }
        }

        if (isBomb) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (bomb[i][j] == '*') {
                        board[i][j] = '*';
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
