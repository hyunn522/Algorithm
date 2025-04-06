import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int answer = 0;
        int start = 0;
        int end = people.length - 1;
        while (start <= end) {
            if (people[start] + people[end] <= limit) start++; // 둘 다 태울 수 있음
            end--; // 무거운 사람은 혼자 보냄
            answer++;
        }
        
        return answer;
    }
}