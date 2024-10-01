import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        boolean answer = true;
        
        char[] list = s.toCharArray();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty()) stack.pop();
                else return false;
            }
        }
        
        if (!stack.isEmpty()) return false;
        else return true;
    }
}