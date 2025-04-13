import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        /*
         피보나치 수열
         n = 1 -> 1 -> 1
         n = 2 -> 00, 11 -> 1 + 1 = 2
         n = 3 -> 001, 100, 111 -> 2 + 1 = 3
         n = 4 -> 0000, 0011, 1001, 1100, 1111 -> 1 + 3 + 1 = 5
         n = 5 -> 00001, 00100, 10000, 00111, 10011, 11001, 11100, 11111 -> 3 + 4 + 1 = 8
         */

        if (n == 1) {
            System.out.println(1);
            return;
        } else if (n == 2) {
            System.out.println(2);
            return;
        } else {
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
            }
        }

        System.out.println(dp[n - 1] % 15746);
    }
}
