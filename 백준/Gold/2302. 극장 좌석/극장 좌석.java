import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] seats = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            seats[Integer.parseInt(br.readLine())] = true; // 고정석
        }

        int[] dp = new int[41];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int cnt = 0;
        long answer = 1;
        for (int i = 1; i <= n; i++) {
            if (seats[i]) { // 고정석인 경우 건너뜀
                answer *= dp[cnt];
                cnt = 0;
            } else {
                cnt++;
            }

        }
        answer *= dp[cnt];

        System.out.println(answer);
    }
}