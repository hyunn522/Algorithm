import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] dp = new int[30][30]; // iCj

            for (int i = 0; i < 30; i++) {
                dp[i][0] = dp[i][i] = 1;
            }

            for (int i = 2; i < 30; i++) {
                for (int j = 1; j < 30; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            
            sb.append(dp[m][n] + "\n");
        }

        System.out.println(sb);
    }
}