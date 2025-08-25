import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] vip = new int[m];

        for (int i = 0; i < m; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1]; // 구간 길이가 i일 때의 경우의 수
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int idx = 0; // 직전 vip 좌석 번호
        long answer = 1;
        for (int i = 0; i < m; i++) {
            int length = vip[i] - idx - 1;
            answer *= dp[length];
            idx = vip[i];
        }

        answer *= dp[n - idx];
        
        System.out.println(answer);
    }
}
