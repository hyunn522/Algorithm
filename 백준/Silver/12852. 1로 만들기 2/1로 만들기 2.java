import java.io.*;

public class Main { 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] dp = new int[n + 1]; // i가 1이 되기 위한 최소 연산 횟수
		int[] before = new int[n + 1]; // i가 되기 직전의 경로
		dp[1] = 0; // 이미 1이므로 0번
		
		for (int i = 2; i <= n; i++) {
			// case 1) -1 연산 수행
			dp[i] = dp[i - 1] + 1; 
			before[i] = i - 1;
			
			// case 2) /3이 연산 횟수가 더 적으면 갱신
			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) { 
				dp[i] = dp[i / 3] + 1;
				before[i] = i / 3;
			}
			
			// case 3) /2가 연산 횟수가 더 적으면 갱신
			if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) { 
				dp[i] = dp[i / 2] + 1;
				before[i] = i / 2;
			}
		}
		
		sb.append(dp[n] + "\n");
		while (n > 0) {
			sb.append(n + " ");
			n = before[n];
		}
		System.out.println(sb);
	}
}
