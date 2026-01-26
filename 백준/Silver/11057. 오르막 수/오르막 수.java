import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];

        if (n == 1) {
            System.out.println(10);
            return;
        }

        if (n == 2) {
            System.out.println(55);
            return;
        }

        for (int j = 0; j <= 9; j++) {
            dp[1][j] = j + 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
            }
        }

        System.out.println(dp[n][9]);
    }
}