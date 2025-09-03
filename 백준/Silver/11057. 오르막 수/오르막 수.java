import java.io.*;

public class Main { 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][10]; // 길이가 i이면서 j로 끝나는 오르막 수의 개수
		
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][0] = 1;
				} else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			answer = (answer + dp[n][i]) % 10007;
		}
		System.out.println(answer);
	}
}
