import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        int[] dp = new int[k + 1]; // i원을 만들 수 있는 경우의 수
        dp[0] = 1; // 0원을 만드는 경우의 수 = 1 : 아무것도 내지 않음

        for (int coin : coins) { // 순서 고려하지 않기 위함
            for (int i = coin; i <= k; i++) { // 이 동전으로 만들 수 있는 금액
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(dp[k]);
    }
}