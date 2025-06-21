import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            long result = 0;
            for (int j = 0; j < i; j++) {
                result += dp[j] * dp[i - 1 - j];
            }
            dp[i] = result;
        }

        System.out.println(dp[n]);
    }
}