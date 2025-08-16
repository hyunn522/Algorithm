import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }
        
        int truckCnt = truck_weights.length;
        int truckIdx = 0;
        int weightSum = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            time++;
            
            weightSum -= queue.poll();
            
            if (truckIdx < truckCnt) {
                int nextWeight = truck_weights[truckIdx];
                if (weightSum + nextWeight <= weight) {
                    queue.offer(nextWeight);
                    truckIdx++;
                    weightSum += nextWeight;
                } else {
                    queue.offer(0);
                }
            }       
        }
        
        return time;
    }
}