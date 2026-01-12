import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] schedule = new int[n + 1][2];
        int[] dp = new int[n + 2]; // i일부터 n + 1일까지 낼 수 있는 최대 수익

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i >= 1; i--) {
            int next = i + schedule[i][0];

            if (next > n + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], schedule[i][1] + dp[next]);
            }
        }

        System.out.println(dp[1]);
    }
}