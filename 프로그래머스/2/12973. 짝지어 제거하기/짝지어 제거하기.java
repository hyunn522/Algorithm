import java.util.*;

class Solution{
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) stack.push(c);
            else {
                if (c == stack.peek()) {
                    stack.pop();
                } else stack.push(c);
            }
        }
        
        return stack.size() > 0 ? 0 : 1;
    }
}