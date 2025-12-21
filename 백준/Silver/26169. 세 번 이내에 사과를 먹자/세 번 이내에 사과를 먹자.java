import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int SIZE = 5;
    static int[][] board = new int[SIZE][SIZE];
    static int r, c, answer = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dfs(r, c, 0, 0);
        System.out.println(answer >= 2 ? 1 : 0);
    }

    private static void dfs(int x, int y, int depth, int apple) {
        if (depth == 3) {
            answer = Math.max(answer, apple);
            return;
        }

        int curBoard = board[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) {
                continue;
            }

            if (board[nx][ny] == 1) {
                board[x][y] = -1;
                dfs(nx, ny, depth + 1, apple + 1);
                board[x][y] = curBoard;
            } else if (board[nx][ny] == 0) {
                board[x][y] = -1;
                dfs(nx, ny, depth + 1, apple);
                board[x][y] = curBoard;
            }
        }
    }
}