import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n + 1][2]; // i를 만들기 위해 0과 1이 몇 번씩 사용됐는지
            // 0 = 0
            dp[0][0] = 1;
            dp[0][1] = 0;

            if (n > 0) {
                // 1 = 1
                dp[1][0] = 0;
                dp[1][1] = 1;

                for (int i = 2; i <= n; i++) {
                    dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
                    dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
                }
            }

            sb.append(dp[n][0] + " " + dp[n][1] + "\n");
        }

        System.out.println(sb);
    }
}