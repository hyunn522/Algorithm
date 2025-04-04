import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        String prevLast = "";
        int cnt = 0;
        
        for (String word : words) {
            cnt++;
            if (set.contains(word) || !word.startsWith(prevLast)) {
                int num = cnt % n == 0 ? n : cnt % n;
                int turn = cnt % n == 0 ? cnt / n: cnt / n + 1;
                return new int[]{num, turn};
            }
            else {
                set.add(word);
                prevLast = word.substring(word.length() - 1);
            }
        }
        
        return new int[]{0, 0};
    }
}