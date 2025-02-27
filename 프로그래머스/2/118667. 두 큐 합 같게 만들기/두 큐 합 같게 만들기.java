import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int size = queue1.length;
        int answer = 0;
        
        Queue<Integer> q1 = init(queue1);
        Queue<Integer> q2 = init(queue2);
        Long sum1 = getSum(q1);
        Long sum2 = getSum(q2);
        
        if ((sum1 + sum2) % 2 == 1) return -1;
        
        while (sum1 != sum2) {
            if (answer >= 4 * size) return -1;
            
            if (sum1 > sum2) {
                if (q1.isEmpty()) return -1;
                Integer n = q1.poll();
                q2.add(n);
                sum1 -= n;
                sum2 += n;
            } else if (sum1 < sum2) {
                if (q2.isEmpty()) return -1;
                Integer n = q2.poll();
                q1.add(n);
                sum1 += n;
                sum2 -= n;
            } else break;
            
            answer++;
        }
        return answer;
    }
    
    private Queue<Integer> init(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        for (int i : arr) {
            q.add(i);
        }
        return q;
    }
    
    private Long getSum(Queue<Integer> q) {
        Long sum = 0L;
        for (Integer i : q) {
            sum += i;
        }
        return sum;
    }
}