import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        Arrays.fill(students, 1); 
        
        // 잃어버린 학생
        for (int l : lost) {
            students[l - 1]--;
        }
        
        // 여분이 있는 학생
        for (int r : reserve) {
            students[r - 1]++;
        }
        
        for (int i = 0; i < students.length; i ++) {
            if (students[i] == 0) {
                // 앞 학생이 체육복이 있을 때
                if (i > 0 && students[i - 1] > 1) {
                    students[i - 1]--;
                    students[i]++;
                } else if (i < (n - 1) && students[i + 1] > 1) { // 뒤 학생이 체육복이 있을 때
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }
        
        // 체육복을 가지고 있는 학생 수
        int answer = 0;
        for (int s : students) {
            if (s > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}