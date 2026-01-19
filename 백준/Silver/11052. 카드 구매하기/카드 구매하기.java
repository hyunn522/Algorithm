import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n + 1]; // 카드가 i개 들어있는 카드팩의 금액
        int[] dp = new int[n + 1]; // 카드를 i개 구매할 때 최대 금액

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) { // 마지막에 선택한 카드팩에 들어있는 카드 개수
                dp[i] = Math.max(dp[i - j] + cards[j], dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}