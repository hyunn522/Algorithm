import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n]; // 삼각형
        int[][] dp = new int[n][n]; // 각 층의 각 칸에서의 최대 합

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = graph[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) dp[i][j] = (Math.max(dp[i - 1][j - 1], dp[i - 1][j])) + graph[i][j];
                else dp[i][j] = dp[i - 1][j] + graph[i][j];
            }
        }

        int max = 0;
        for (int i : dp[n - 1]) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}