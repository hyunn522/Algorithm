import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);

        for (int i = 0; i < weights.length - 1; i++) {
            for (int j = i + 1; j < weights.length; j++) {
               if (weights[j] == weights[i] || weights[j] * 2 == weights[i] * 3 || weights[j] * 3 == weights[i] * 4 || weights[j] == (long)weights[i] * 2) {
                    answer++;
                } else if (weights[j] > (long)weights[i] * 2) break;   
            }
        }
        
        return answer;
    }
}