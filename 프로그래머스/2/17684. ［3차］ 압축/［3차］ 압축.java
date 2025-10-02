import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int startIdx = 0;
        int addIdx = 26;
        int msgLength = msg.length();
        
        Map<String, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        while (startIdx < msgLength) {
            int result = -1;
            
            // 비교할 문자열 선정 : 사전에 있는 것들 중 가장 긴 문자열로 선정해야 함
            for (int i = msgLength; i > startIdx; i--) {
                String curStr = msg.substring(startIdx, i);
                if(map.keySet().contains(curStr)) {
                    // 사전에 있으면 색인 출력
                    answer.add(map.get(curStr));
                    
                    // map에 이전에 봤던(인덱스가 1 컸던) 글자 등록
                    if (i < msgLength) {
                        map.put(msg.substring(startIdx, i + 1), ++addIdx);
                    }
                    
                    // 다음으로 볼 인덱스 설정
                    startIdx += curStr.length();
                    
                    break;
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}