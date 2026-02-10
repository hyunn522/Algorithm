import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] times = new int[n + 1][m]; // 각 회차별 무기의 소요 시간

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                times[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][m]; // i회차에서 무기 j를 선택했을 때 클리어 시간의 최솟값
        for (int j = 0; j < m; j++) { // 1회차 초기화
            dp[1][j] = times[1][j];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                int prevMin = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        prevMin = Math.min(dp[i - 1][k], prevMin);
                    }
                }
                
                dp[i][j] = prevMin + times[i][j];
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i : dp[n]) {
            answer = Math.min(i, answer);
        }
        System.out.println(answer);
    }
}