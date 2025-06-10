import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n];

            for (int i = 0; i < n; i++) {
                if (i == 0 || i == 1 || i == 2) dp[i] = 1;
                else if (i == 3 || i == 4) dp[i] = 2;
                else {
                    dp[i] = dp[i - 5] + dp[i - 1];
                }
            }

            sb.append(dp[n - 1] + "\n");
        }

        System.out.println(sb);
    }
}