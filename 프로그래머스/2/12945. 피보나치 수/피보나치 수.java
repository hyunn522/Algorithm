import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);
        
        for (int i = 3; i <= n; i++) {
            list.add((list.get(i - 2) + list.get(i - 1)) % 1234567);
        }
        
        return list.get(n);
    }
}