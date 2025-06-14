import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int fromLeft = j > 0 ? dp[i][j - 1] : 0;
                int fromRight = i > 0 ? dp[i - 1][j] : 0;
                int fromDiag = (i > 0 && j > 0) ? dp[i - 1][j - 1] : 0;
                dp[i][j] = map[i][j] + Math.max(Math.max(fromLeft, fromRight), fromDiag);
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}