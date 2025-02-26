import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 문자열 파싱
        s = s.substring(1, s.length() - 1);
        String[] inputTuple = s.split("},");
        for (int i = 0; i < inputTuple.length; i++) {
            inputTuple[i] = inputTuple[i].replace("{", "");
            inputTuple[i] = inputTuple[i].replace("}", "");
        }
        
        // 집합 길이를 기준으로 정렬
        Arrays.sort(inputTuple, (s1, s2) -> s1.length() - s2.length());
        
        // 정렬된 집합의 원소들로 튜플 구성
        List<String> list = new ArrayList<>();
        for (String t : inputTuple) {
            String[] tokens = t.split(",");
            for (String token : tokens) {
                if (!list.contains(token)) list.add(token);
            }
        }
        
        // 정답 구성
        int totalLength = inputTuple[inputTuple.length - 1].split(",").length;
        int[] answer = new int[totalLength];
        for (int i = 0; i < totalLength; i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        return answer;
    }
}