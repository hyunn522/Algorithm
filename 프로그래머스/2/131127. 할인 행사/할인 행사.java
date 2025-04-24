import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                String discountItem = discount[j];
                discountMap.put(discountItem, discountMap.containsKey(discountItem) ? discountMap.get(discountItem) + 1 : 1);
            }
            
            boolean isPossible = true;
            for (int j = 0; j < want.length; j++) {
                String wantName = want[j];
                int wantNumber = number[j];
                
                if (!discountMap.containsKey(wantName) || discountMap.get(wantName) != wantNumber) {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) answer++;
        }
        
        return answer;
    }
}