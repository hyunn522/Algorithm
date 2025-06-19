import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][n];

        if (n == 1 || k == 0 || k == n) {
            System.out.println(1);
            return;
        }

        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 0;j <= i; j++) {
                if (j == 0 || j == n - 1) dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n - 1][k - 1]);
    }
}