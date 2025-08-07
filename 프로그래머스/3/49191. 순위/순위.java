import java.util.*;

class Solution {
    
    static List<Integer>[] winGraph;
    static List<Integer>[] looseGraph;
    static int[] winCnt, looseCnt;
    
    public int solution(int n, int[][] results) {
        // 그래프에 나에게 진 사람, 나에게 이긴 사람 모두 저장
        winGraph = new ArrayList[n];
        looseGraph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            winGraph[i] = new ArrayList<>();
            looseGraph[i] = new ArrayList<>();
        }
        
        for (int[] result : results) {
            int winner = result[0] - 1;
            int looser = result[1] - 1;
            winGraph[winner].add(looser);
            looseGraph[looser].add(winner);
        }
        
        winCnt = new int[n];
        looseCnt = new int[n];
        
        for (int i = 0; i < n; i++) {
            // 이긴 사람 개수 카운트
            bfs(i, n, true);
            
            // 진 사람 개수 카운트
            bfs(i, n, false);
        }
        
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (winCnt[i] + looseCnt[i] == n - 1) answer++;
        }
        return answer;
    }
    
    static void bfs(int start, int n, boolean isWinCnt) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean visited[] = new boolean[n];
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int next : (isWinCnt ? winGraph[cur] : looseGraph[cur])) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        
        int result = -1; // 자기 자신 제외
        for (boolean v : visited) {
            if (v) result++;
        }
        
        if (isWinCnt) winCnt[start] = result;
        else looseCnt[start] = result;
    }
}