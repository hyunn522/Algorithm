import java.util.*;
import java.util.Map.*;

class Solution {
    
    static Map<String, Integer> map; // {조합, 빈도수}
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        
        // 1. 각 주문들을 알파벳 순서로 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }
        
        // 2. 코스 길이별 조합 생성
        for (int l : course) {
            // 각 주문에서 길이가 l인 조합 생성
            map = new HashMap<>();
            for (String order : orders) {
                if (order.length() < l) {
                    continue;
                }
                combine(order, 0, l, new StringBuilder());
            }
            
            // 3. 코스 길이별 최빈값 찾음
            int maxCnt = 0;
            for (int c : map.values()) {
                maxCnt = Math.max(maxCnt, c);
            }
            
            if (maxCnt < 2) {
                continue;
            }
            
            // 4. 정답 리스트에 추가
            for (Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue() == maxCnt) {
                    answerList.add(e.getKey());
                }
            }
        }
        
        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }
    
    static void combine(String order, int start, int targetLength, StringBuilder sb) {
        // 현재 조합에 대한 빈도수 저장
        if (sb.length() == targetLength) {
            map.merge(sb.toString(), 1, Integer::sum);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            combine(order, i + 1, targetLength, sb);
            sb.deleteCharAt(sb.length() - 1); // 백트래킹
        }
    }
}