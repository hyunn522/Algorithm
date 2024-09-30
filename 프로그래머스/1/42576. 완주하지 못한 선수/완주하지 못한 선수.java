import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 1. 알파벳 순으로 정렬 후 이진탐색
        // 2. completion에 있는 애들을 participant에서 하나씩 빼면서 수행 -> 시간 초과 예상
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i < completion.length ; i++ ) {
            if (participant[i].equals(completion[i])) continue;
            else return participant[i];
        }
        return participant[participant.length - 1];
    };
}