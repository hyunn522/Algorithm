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

        int[] dp = new int[k + 1]; // i원을 만들기 위해 사용한 동전의 최소 갯수
        Arrays.fill(dp, 123456789);
        dp[0] = 0;

        for (int i = 1; i <= k; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    break;
                }

                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }

        System.out.println(dp[k] == 123456789 ? -1 : dp[k]);
    }
}