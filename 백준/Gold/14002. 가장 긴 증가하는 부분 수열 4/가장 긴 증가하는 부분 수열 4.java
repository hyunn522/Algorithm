import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main { 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[][] dp = new int[n][2]; // {현재까지의 최대 길이, 바로 이전의 인덱스}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
			
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (arr[j] < arr[i] && dp[i][0] < dp[j][0] + 1) { // 최대 수열 갱신
						dp[i][0] = dp[j][0] + 1;
						dp[i][1] = j;
					}
				}
			}
		}
		
		int maxIdx = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i][0] > dp[maxIdx][0]) {
				maxIdx = i;
			}
		}

		int idx = maxIdx;
		List<Integer> answer = new ArrayList<>();
		while (true) {
			answer.add(arr[idx]);
			if (dp[idx][1] == idx) break;
			idx = dp[idx][1];
		}
		Collections.reverse(answer);
		
		sb.append(answer.size() + "\n");
		for (int i : answer) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
}
