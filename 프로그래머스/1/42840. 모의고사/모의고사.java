import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];
        int idx = 0;
        for (int answer : answers) {
            if (answer == pattern1[idx % pattern1.length]) scores[0]++;
            if (answer == pattern2[idx % pattern2.length]) scores[1]++;
            if (answer == pattern3[idx % pattern3.length]) scores[2]++;
            idx++;
        }
        
        List<Integer> resultList = new ArrayList<>();
        int maxScore = 0;
        for (int i = 0; i < 3; i++) {
            int score = scores[i];
            if (score > maxScore) {
                resultList.clear();
                maxScore = score;
                resultList.add(i);
            } else if (score == maxScore) {
                resultList.add(i);
            }
        }
        
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i) + 1;
        }
        return result;
    }
}