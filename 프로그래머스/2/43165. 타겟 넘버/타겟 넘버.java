class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        // 모든 수에 대해 +, -를 진행한 결과 target과 같은 결과의 개수를 반환
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }
}