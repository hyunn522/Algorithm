import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
        } else if (n > 0) {
            if (n == 1) {
                System.out.println(1);
                System.out.println(1);
                return;
            }

            long[] dp = new long[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
            }

            System.out.println(dp[n] < 0 ? -1 : 1);
            System.out.println(dp[n]);
        } else {
            n *= -1; // 양수로 변환

            long[] dp = new long[n + 2];
            dp[n + 1] = 1;
            dp[n] = 0;
            for (int i = n - 1; i >= 0; i--) {
                dp[i] = (dp[i + 2] - dp[i + 1]) % 1000000000;
            }

            System.out.println(dp[0] < 0 ? -1 : 1);
            System.out.println(dp[0] < 0 ? dp[0] * -1 : dp[0]);
        }
    }
}