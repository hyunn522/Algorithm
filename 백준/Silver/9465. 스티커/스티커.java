import java.io.*;
import java.util.StringTokenizer;

public class Main { 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][2];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				map[i][0] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
			int[][] dp = new int[n][2]; // (i, j)의 스티커를 뗄 때의 최대 점수
			dp[0][0] = map[0][0];
			dp[0][1] = map[0][1];
			
			if (n > 1) {
				dp[1][0] = dp[0][1] + map[1][0];
				dp[1][1] = dp[0][0] + map[1][1];
			}
			
			// 반대 행의 히스토리에서 갱신
			for (int i = 2; i < n; i++) {
				dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + map[i][0];
				dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + map[i][1];
			}
			
			sb.append(Math.max(dp[n - 1][0], dp[n - 1][1]) + "\n");
		}
		
		System.out.println(sb);
	}
}
