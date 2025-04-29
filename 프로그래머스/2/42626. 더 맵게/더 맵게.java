import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }
            
        int answer = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            int newScoville = pq.poll() + pq.poll() * 2;
            pq.add(newScoville);
            answer++;
        }

        if (pq.peek() < K) return -1;
        
        return answer;
    }
}