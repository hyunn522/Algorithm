class Solution {
    public int solution(int n) {
        int answer = 1; // 자기 자신 1개로 이루어진 경우
        
        for (int i = 1; i <= n / 2; i++) {
            int sum = i;
            
            for (int j = i + 1; j <= n; j++) {
                sum += j;
            
                if (sum > n) {
                    break;
                }
                
                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}