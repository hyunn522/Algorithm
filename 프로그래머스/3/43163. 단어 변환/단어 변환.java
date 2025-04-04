import java.util.*;

class Solution {
    
    boolean[] visited;
    int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        // // target이 words 내에 있지 않은 경우
        // if (!List.of(words).contains(target)) return 0;
        
        // 한 글자만 다른 단어를 찾음
        dfs(begin, target, words, 0);
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            
            int sameCnt = 0;
            for (int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) sameCnt++;
            }
            
            if (sameCnt == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}