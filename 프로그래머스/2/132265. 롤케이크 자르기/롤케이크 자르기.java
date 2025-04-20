import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> first = new HashSet<>();
        Map<Integer, Integer> second = new HashMap<>();
        
        for (int t : topping) {
            second.put(t, second.getOrDefault(t, 0) + 1);
        }
        
        for (int t : topping) {
            first.add(t);
            
            if (second.get(t) > 0) {
                second.put(t, second.get(t) - 1);
            }
            
            if (second.get(t) == 0) second.remove(t);
            
            if (first.size() == second.size()) answer++;
        }
        
        return answer;
    }
}