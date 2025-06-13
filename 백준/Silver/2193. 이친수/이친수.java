import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n];

        if (n == 1 || n == 2) {
            System.out.println(1);
        } else if (n == 3) {
            System.out.println(2);
        } else {
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            System.out.println(dp[n - 1]);
        }
        // 1 -> 1(1) / 2 -> 1(10) / 3 -> 2(100, 101) / 4 -> 3(1000, 1001, 1010) / 5 -> 5(10000, 10001, 10010, 10100, 10101)
    }
}