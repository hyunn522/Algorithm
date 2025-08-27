import java.io.*;
import java.util.StringTokenizer;

public class Main { 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n + 1];
		int[] dp = new int[n + 1]; // i개의 카드를 갖기 위한 최대 금액
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			dp[i] = cards[i];
			for (int j = 1; j <= i; j++) { // 가능한 모든 조합 확인
				dp[i] = Math.max(dp[i], dp[i - j] + cards[j]);
			}
		}
		
		System.out.println(dp[n]);
	}
}
