import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n < 2) {
                System.out.println(1);
            } else if (n == 2) {
                System.out.println(2);
            } else if (n == 3) {
                System.out.println(4);
            } else {
                long[] dp = new long[n + 1];
                dp[0] = dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;
                for (int i = 4; i <= n; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
                }
                System.out.println(dp[n]);
            }
        }
    }
}