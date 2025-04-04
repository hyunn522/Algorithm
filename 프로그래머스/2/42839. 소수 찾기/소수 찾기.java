import java.util.*;

class Solution {
    
    static List<Integer> resultList = new ArrayList<>();
    static boolean[] visited = new boolean[7];
    
    public int solution(String numbers) {
        // 가능한 길이별 모든 숫자 조합
        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, "", i + 1);
        }
        
        int answer = 0;
        
        // 소수 판별
        for (int result : resultList) {
            if (isPrime(result)) answer++;
        }
        
        return answer;
    }
    
    static void dfs(String str, String temp, int depth) {
        if (temp.length() == depth) { // 목표 길이가 됐을 때
            int num = Integer.parseInt(temp);
            if (!resultList.contains(num)) resultList.add(num);
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(str, temp + str.charAt(i), depth);
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num) {
        if (num < 2) return false;
            
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}