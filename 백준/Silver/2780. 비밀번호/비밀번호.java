import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] adj = {
                {7},
                {2, 4},
                {1, 3, 5},
                {2, 6},
                {1, 5, 7},
                {2, 4, 6, 8},
                {3, 5, 9},
                {0, 4, 8},
                {5, 7, 9},
                {6, 8}
        };

        int[][] dp = new int[1001][10]; // 길이가 i면서 j로 끝나는 비밀번호의 개수
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= 1000; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k : adj[j]) {
                    dp[i][j] = (dp[i - 1][k] + dp[i][j]) % 1234567;
                }
            }
        }

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            for (int i = 0; i < 10; i++) {
                answer = (answer + dp[n][i]) % 1234567;
            }
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }
}