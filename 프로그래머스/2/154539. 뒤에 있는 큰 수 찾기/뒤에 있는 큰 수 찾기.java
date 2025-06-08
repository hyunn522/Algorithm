import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = numbers.length - 1 ; i >= 0; i--) {
            int cur = numbers[i];
            
            // stack에서 현재 수보다 작은 수 제거
            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }   
            
            // 현재 수보다 큰 수가 존재하지 않는 경우 -> -1, 존재한다면 정답에 추가
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(cur);
        }
        
        return answer;
    }
}