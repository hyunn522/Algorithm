import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int absN = Math.abs(n);

        if (absN == 0) {
            System.out.println(0 + "\n" + 0);
            return;
        }

        if (absN == 1 || absN == 2) {
            System.out.println(n == -2 ? -1 : 1);
            System.out.println(1);
            return;
        }

        long[] dp = new long[absN + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= absN; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000000;
        }

        System.out.println(n > 0 ? 1 : (n == 0 ? 0 : (absN % 2 == 1 ? 1 : -1)));
        System.out.println(dp[absN]);
    }
}