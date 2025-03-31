import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        // 종류별로 옷의 개수 저장
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        
        int answer = 1;
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            answer *= it.next() + 1;
        }
        
        return answer - 1;
    }
}