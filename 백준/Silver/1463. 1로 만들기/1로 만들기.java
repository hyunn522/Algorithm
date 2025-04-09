import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1]; // i를 1로 만들 때까지의 최소 연산 횟수
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // 1을 뺀 값
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 1을 빼는 경우와 2로 나누는 경우 중 연산 횟수가 더 작은 경우 선택
            }
            if (i % 3 == 0) { 
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 1을 빼는 경우와 3으로 나누는 경우 중 연산 횟수가 더 작은 경우 선택
            }
        }

        System.out.println(dp[n]);
    }
}
