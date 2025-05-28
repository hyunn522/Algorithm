import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int size = A.length;
        int answer = 0;
        
        for (int i = 0; i < size; i++) {
            answer += A[i] * B[size - 1 - i];
        }

        return answer;
    }
}