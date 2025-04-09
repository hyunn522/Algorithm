import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11]; // i를 1, 2, 3의 합으로 나타내는 경우의 수
            dp[0] = dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            sb.append(dp[n] + "\n");
        }

        System.out.println(sb);

    }
}
