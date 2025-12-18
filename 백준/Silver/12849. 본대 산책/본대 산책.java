import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());

        // 현재 시간에 i 건물에 있는 경우의 수
        long[] dp = new long[8];
        dp[0] = 1; // 0분일 때 0에 있는 경우의 수 = 1
        long mod = 1000000007;

        for (int t = 0; t < d; t++) {
            /**
             * (t + 1) 시간에 i 건물에 있는 경우의 수
             * == t 시간에 i 건물에 인접한 건물들에 있는 경우의 수의 합
            */
            
            long[] next = new long[8];

            next[0] = (dp[1] + dp[2]) % mod;
            next[1] = (dp[0] + dp[2] + dp[3]) % mod;
            next[2] = (dp[0] + dp[1] + dp[3] + dp[4]) % mod;
            next[3] = (dp[1] + dp[2] + dp[4] + dp[5]) % mod;
            next[4] = (dp[2] + dp[3] + dp[5] + dp[6]) % mod;
            next[5] = (dp[3] + dp[4] + dp[7]) % mod;
            next[6] = (dp[4] + dp[7]) % mod;
            next[7] = (dp[5] + dp[6]) % mod;

            dp = next;
        }

        System.out.println(dp[0]);
    }
}