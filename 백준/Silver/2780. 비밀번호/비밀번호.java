import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int[][] nears = {
                {7},
                {2, 4},
                {1, 3, 5},
                {2, 6},
                {1, 5, 7},
                {2, 4, 6, 8},
                {3, 5, 9},
                {0, 4, 8},
                {5, 7, 9},
                {6, 8}
        };
        int NUM_CNT = 10;
        int MOD = 1234567;

        int[][] dp = new int[1001][NUM_CNT]; // 길이가 i면서 j로 끝나는 경우의 수

        for (int i = 1; i <= 1000; i++) {
            if (i == 1) {
                Arrays.fill(dp[1], 1);
                continue;
            }

            for (int j = 0; j < NUM_CNT; j++) {
                for (int near : nears[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][near]) % MOD;
                }
            }
        }

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int answer = 0;
            for (int i = 0; i < NUM_CNT; i++) {
                answer = (answer + dp[n][i]) % MOD;
            }
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }
}