import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        
        if (arr[0].equals("0")) return "0";
        
        String answer = "";
        for (String n : arr) {
            answer += n;
        }
        
        return answer;
    }
}