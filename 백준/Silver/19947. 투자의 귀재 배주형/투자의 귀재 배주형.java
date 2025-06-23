import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[] dp = new int[y + 1];
        dp[0] = h;

        for (int i = 1; i <= y; i++) {
            dp[i] = (int)(dp[i - 1] * 1.05);

            if (i >= 5) dp[i] = Math.max(dp[i], (int)(dp[i - 5] * 1.35));
            if (i >= 3) dp[i] = Math.max(dp[i], (int)(dp[i - 3] * 1.2));
        }

        System.out.println(dp[y]);
    }
}