import java.util.*;

class Solution {
    public int solution(int[] order) {
        int curFront = 1; // 컨테이너 벨트의 가장 앞에 놓인 상자 번호
        Deque<Integer> second = new ArrayDeque<>(); // 보조 컨테이너 벨트
        int answer = 0;
        
        for (int curOrder : order) {
            // case 1) 컨테이너 벨트의 가장 앞 상자 == 현재 순서의 상자
            if (curFront == curOrder) {
                curFront++;
                answer++;
                continue;
            }
            
            // case 2) 컨테이너 벨트의 가장 앞 상자 > 현재 순서의 상자
            if (curFront > curOrder) {
                if (second.pop() != curOrder) break;
                else answer++;
            }
            
            // case 3) 컨테이너 벨트의 가장 앞 상자 < 현재 순서의 상자 -> 보조 컨테이너 벨트로 이동
            if (curFront < curOrder) {
                while (curOrder != curFront) {
                    second.push(curFront);
                    curFront++;    
                }
                curFront++;
                answer++;
                continue;
            }
        }
        
        return answer;
    }
}