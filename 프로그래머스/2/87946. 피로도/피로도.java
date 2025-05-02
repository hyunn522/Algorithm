import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    
    private void dfs(int energy, int[][] dungeons, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && energy >= dungeons[i][0]) {
                visited[i] = true;
                dfs(energy - dungeons[i][1], dungeons, depth + 1);
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer, depth);
    }
}