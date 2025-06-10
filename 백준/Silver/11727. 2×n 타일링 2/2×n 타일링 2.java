import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) dp[i] = 1;
            else if (i == 1) dp[i] = 3;
            else dp[i] = (2 * dp[i - 2] + dp[i - 1]) % 10007;
        }

        System.out.println(dp[ n - 1]);
    }
}