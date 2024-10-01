import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> spendDays = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList();
        int max = 0;
        int count = 1;
        
        // queue에 남은 일을 하는 데에 걸리는 일수 저장
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0)
                spendDays.addLast((100 - progresses[i]) / speeds[i]);
            else
                spendDays.addLast((100 - progresses[i]) / speeds[i] + 1);
        }
        
        for (int i = 0; i < progresses.length; i++) {
            int last = spendDays.pop();
            if (max < last) { // 이전 작업보다 많이 걸리는 경우 -> 새로운 배포
                if (i > 0) list.add(count);
                max = last;
                count = 1;
            } else { // 이전 작업보다 적거나 같게 걸리는 경우 -> 앞 배포에 병합
                count++;
            }
            if (i == progresses.length - 1) list.add(count);
        }
        
        int[] answer = list.stream()
            .mapToInt(i -> i)
            .toArray();
        
        return answer;
    }
}