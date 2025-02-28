import java.util.*;


class Solution {
        
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> map = new HashMap<>();
        String[] allPersonalityType = {"R", "T", "C", "F", "J", "M", "A", "N"};
        for (String t : allPersonalityType) map.put(t, 0);
        
        // 점수 계산
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            String personality = "";
            int count = 0;
            if (choice <= 3) {
                personality = String.valueOf(survey[i].toCharArray()[0]);
                count += (4 - choice);
            } else if (choice >= 5) {
                personality = String.valueOf(survey[i].toCharArray()[1]);
                count += (choice - 4);
            } else continue;
            
            map.put(personality, map.get(personality) + count);
        }
        
        // 정답 구성
        String answer = "";
        if (map.get("T") > map.get("R")) answer += "T";
        else answer += "R";
        if (map.get("F") > map.get("C")) answer += "F";
        else answer += "C";
        if (map.get("M") > map.get("J")) answer += "M";
        else answer += "J";
        if (map.get("N") > map.get("A")) answer += "N";
        else answer += "A";
        return answer;
    }
}