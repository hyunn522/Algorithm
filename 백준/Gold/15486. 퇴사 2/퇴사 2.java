import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n + 1];
        int[] prices = new int[n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[n + 2];

        for (int i = n; i > 0; i--) {
            int curTime = times[i];
            int curPrice = prices[i];

            if (i + curTime > n + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + curTime] + curPrice, dp[i + 1]);
            }
        }

        System.out.println(dp[1]);
    }
}