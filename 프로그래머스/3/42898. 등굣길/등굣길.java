class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        
        // 물에 잠긴 지역 마스킹
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        // 최단 경로 누적
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 시작점 스킵
                if (i == 1 && j == 1) {
                    continue;
                }
                
                // 물에 잠긴 지역은 이동 불가 -> 다음 계산 위해 값 변경
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        
        return dp[n][m];
    }
}