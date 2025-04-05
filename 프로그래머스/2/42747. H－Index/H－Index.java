import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int num = citations.length;
        
        for (int i = 0; i < num; i++) { 
            int h = num - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}