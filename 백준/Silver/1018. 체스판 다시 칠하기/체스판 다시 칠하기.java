import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m, min = Integer.MAX_VALUE;
    static boolean[][] board;
    static final int SIZE = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0;j < m; j++) {
                board[i][j] = input.charAt(j) == 'W';
            }
        }

        // 8x8로 가능한 모든 조합에 대해 칠해야 하는 정사각형의 개수 구하기
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0;j < m - 7; j++) {
                getCnts(i, j);
            }
        }

        System.out.println(min);
    }

    private static void getCnts(int x, int y) {
        int endX = x + SIZE;
        int endY = y + SIZE;
        int result = 0;

        boolean rightValue = board[x][y]; // 올바른 색
        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (board[i][j] != rightValue) result++;
                rightValue = !rightValue; // 칸이 지나갈 때마다 색 바뀜
            }

            rightValue = !rightValue; // 줄이 바뀔 때마다 색 바뀜
        }

        result = Math.min(result, 64 - result); // 첫 번째 칸을 기준으로 할 때와 그 반대 색을 기준으로 할 때 중 최소값

        min = Math.min(min, result);
    }
}
