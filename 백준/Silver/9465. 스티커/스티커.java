import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                stickers[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                stickers[1][i] = Integer.parseInt(st.nextToken());
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];
            
            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
            }

            sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
        }

        System.out.println(sb);
    }
}