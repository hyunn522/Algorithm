import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        
        for (int i = 0; i < length; i++) {
            String newS = s.substring(i) + s.substring(0, i);
            Deque<Character> stack = new LinkedList<>();
            
            for (int j = 0; j < length ; j++) {
                char a = newS.charAt(j);
                
                if (stack.isEmpty()) {
                    stack.push(a);
                    continue;
                }
                
                char b = stack.peek();
                if (a == ')' && b == '(') stack.pop();
                else if (a == '}' && b == '{') stack.pop();
                else if (a == ']' && b == '[') stack.pop();
                else stack.push(a);
            } 
            
            if (stack.isEmpty()) answer++;
        }
        
        return answer;
    }
}