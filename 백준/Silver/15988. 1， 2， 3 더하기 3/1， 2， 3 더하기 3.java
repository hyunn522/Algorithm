import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        long[] dp = new long[10000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 10000001; i++) {
            // +1만 하면 되는 경우, +2만 하면 되는 경우, +3만 하면 되는 경우
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n] + "\n");
        }

        System.out.println(sb);
    }
}
