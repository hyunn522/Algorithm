class Solution {
    public int[] solution(int n, long left, long right) {
        int leftA = (int)(left / (long)n); // 몇 번째 묶음인지
        int leftB = (int)(left % (long)n); // 그 묶음 내에서 몇 번째 숫자인지
        
        int answerLength = (int)(right - left) + 1;
        int[] answer = new int[answerLength];
        for (int i = 0; i < answerLength; i++) {
            answer[i] = leftB <= leftA ? leftA + 1 : leftB + 1;
            if (leftB == n - 1) {
                leftA++;
                leftB = 0;
            } else leftB++;
        }
        return answer;
    }
}