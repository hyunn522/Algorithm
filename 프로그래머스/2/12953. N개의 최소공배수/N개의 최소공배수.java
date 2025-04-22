import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            int gcd = gcd(answer, arr[i]);
            answer = answer * arr[i] / gcd;
        }
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}