import java.util.*;

class Solution {
    static int SIZE = 1000001;
    
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1]; // i를 만드는 최소 횟수 저장
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        
        for (int i = x; i <= y; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            
            if (i + n <= y) dp[i + n] = Math.min(dp[i] + 1, dp[i + n]);
            if (i * 2 <= y) dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
            if (i * 3 <= y) dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
        }
        
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}