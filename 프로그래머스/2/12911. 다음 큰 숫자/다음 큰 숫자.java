import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> original = new ArrayList<>();
        while (n > 0) {
            original.add(n % 2);
            n /= 2;
        }
        original.add(0);
        
        int size = original.size();
        int changeIdx = -1;
        int changeCnt = 0;
        boolean isLastOne = false;
        
        // 1로 바꿀 위치 찾기
        for (int i = 0; i < size; i++) {
            int cur = original.get(i);
                        
            if (isLastOne && cur == 0) {
                changeIdx = i;
                break;
            }
            
            if (cur == 1) {
                isLastOne = true;
                changeCnt++;
            }
        }
        
        // 이진수로 변환하면 모든 숫자가 1인 경우
        if (changeIdx == -1) {
            changeIdx = size + 1;
        }
        
        // 다음 큰 숫자 찾기
        original.set(changeIdx, 1);
        changeCnt--;
        for (int i = 0; i < changeIdx; i++) {
            if (changeCnt == 0) {
                original.set(i, 0);
            } else {
                original.set(i, 1);
                changeCnt--;
            }
        }
        
        // 10진수로 변환
        int answer = 0;
        for (int i = 0; i < size; i++) {
            answer += original.get(i) * Math.pow(2, i);
        }
        return answer; 
    }  
}