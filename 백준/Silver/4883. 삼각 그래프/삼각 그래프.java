import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int[][] graph = new int[n][3];
            int[][] dp = new int[n][3];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = graph[0][1];
            dp[0][2] = graph[0][1] + graph[0][2];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + graph[i][0];
                dp[i][1] =
                        Math.min(dp[i][0], Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2]))) + graph[i][1];
                dp[i][2] = Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2])) + graph[i][2];
            }

            sb.append(tc++ + ". " + dp[n - 1][1] + "\n");
        }

        System.out.println(sb);
    }
}