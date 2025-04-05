import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0; 
        
        for (int i = 0; i < number.length() - k; i++) { // 골라야 하는 수의 개수만큼 반복
            char max = '0';
            for (int j = idx; j <= i + k; j++) { // 구간 내에서 최대값 구하기
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1; // 최댓값 바로 다음의 인덱스
                }
            }
            answer.append(max);
        }
        
        return answer.toString();
    }
}