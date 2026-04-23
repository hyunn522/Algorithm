import java.util.*;
import java.util.Map.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>(); // {조합, 빈도수}
    static String targetOrder;
    
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
            for (String order : orders) {
                targetOrder = order;
                dfs(0, "", 0, l);
            }
            
            // 3. 코스 길이별 최빈값 찾음
            int maxCnt = Integer.MIN_VALUE;
            List<String> result = new ArrayList<>();
            for (Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue() < 2) {
                    continue;
                }
                
                if (e.getValue() > maxCnt) {
                    result.clear();
                    result.add(e.getKey());
                    maxCnt = e.getValue();
                } else if (e.getValue() == maxCnt) {
                    result.add(e.getKey());
                }
            }
            
            // 4. 정답 리스트에 추가
            for (String r : result) {
                answerList.add(r);
            }
            
            map.clear();
        }
        
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    static void dfs(int curIdx, String cur, int curLength, int targetLength) {
        // 현재 조합에 대한 빈도수 저장
        if (curLength == targetLength) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }
        
        // 인덱스 초과 방지
        if (curIdx == targetOrder.length()) {
            return;
        }
        
        dfs(curIdx + 1, cur, curLength, targetLength);
        dfs(curIdx + 1, cur + targetOrder.charAt(curIdx), curLength + 1, targetLength);
    }
}