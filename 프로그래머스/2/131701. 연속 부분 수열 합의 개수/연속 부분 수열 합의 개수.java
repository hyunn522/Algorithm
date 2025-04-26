import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 1; i <= elements.length; i++) { // 수열의 길이
            for (int j = 0; j < elements.length; j++) { // 수열의 시작 인덱스
                int sum = 0;
                for (int k = j; k < j + i; k++) {
                    if (k >= elements.length) sum += elements[k - elements.length];
                    else sum += elements[k];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}