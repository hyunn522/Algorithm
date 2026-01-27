import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        int[] dp = new int[n + 1]; // i가 되기 위한 연산의 최소 횟수
        int[] prev = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }

            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }
        }

        int idx = n;
        StringBuilder sb = new StringBuilder();
        while (idx > 0) {
            sb.append(idx).append(" ");
            idx = prev[idx];
        }

        System.out.println(dp[n]);
        System.out.println(sb);
    }
}