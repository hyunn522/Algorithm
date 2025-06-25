import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 1 -> 1 1개
        // 2 -> 1^2 + 1^2 2개
        // 3 -> 1^2 + 1^2 + 1^2 3개
        // 4 -> 2^2 1개
        // 5 -> 1^2 + 2^2 2개
        // 6 -> 1^2 + 1^2 + 2^2 3개
        // 7 -> 1^2 + 1^2 + 1^2 + 2^2 4개
        // 8 -> 2^2 + 2^2 2개
        // 9 -> 3^2 1개
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // i에서 제곱수를 뺀 dp 값 중 가장 작은 값
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }

        System.out.println(dp[n]);
    }
}