import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        int answer = 0;
        
        Deque<Integer> stack = new LinkedList<>();
        
        for (int move : moves) {
            for (int i = 0; i < n; i++) {
                int doll = board[i][move - 1];
                if (doll != 0) {
                    board[i][move - 1] = 0;

                    if (stack.isEmpty()) {
                        stack.push(doll);
                    } else {
                        if (doll == stack.peek()) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(doll);
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
}