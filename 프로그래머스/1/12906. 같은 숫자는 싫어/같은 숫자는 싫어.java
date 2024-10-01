import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        LinkedList<Integer> list = new LinkedList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;   
            } else {
                list.addLast(arr[i]);
            }
        }

        int[] answer = list.stream()
            .mapToInt(i -> i)
            .toArray();
        
        return answer;
    }
}