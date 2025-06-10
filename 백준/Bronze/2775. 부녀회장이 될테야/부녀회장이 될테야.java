import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호
            int[][] dp = new int[k + 1][n]; // 각 층의 호에 사는 사람 수

            // 0층 초기화
            for (int i = 0; i < n; i++) {
                dp[0][i] = i + 1; //
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = 0;
                    for (int l = 0; l <= j; l++) {
                        sum += dp[i - 1][l];
                    }
                    dp[i][j] = sum;
                }
            }

            sb.append(dp[k][n - 1] + "\n");
        }

        System.out.println(sb);
    }
}