import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        int answer = 0;
        
        Deque<Integer> stack = new LinkedList<>();
        boolean[] isEmpty = checkIsEmpty(board);
        
        for (int move : moves) {
            if (isEmpty[move - 1]) continue;
            
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

                    isEmpty = checkIsEmpty(board);
                    break;
                }
            }
        }
        return answer;
    }
    
    private boolean[] checkIsEmpty(int[][] board) {
        boolean[] isEmpty = new boolean[board.length];
        for (int i = 0; i < board.length; i++) {
            isEmpty[i] = true;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] > 0) {
                    isEmpty[i] = false;
                    continue;
                }
            }
        }
        return isEmpty;
    }
}