class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        while (a != b) {
            // 다음 라운드로 이동
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        
        return answer;
    }
}