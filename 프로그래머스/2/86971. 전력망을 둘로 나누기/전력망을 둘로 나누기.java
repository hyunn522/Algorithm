import java.util.*;

class Solution {
    
    static List<List<Integer>> linkedList;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // wires를 양방향 리스트에 저장
        linkedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            linkedList.get(wire[0] - 1).add(wire[1] - 1);
            linkedList.get(wire[1] - 1).add(wire[0] - 1);
        }
        
        List<Integer> answers = new ArrayList<>();
        
        // 모든 경우 다 끊어보기
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0] - 1;
            int v2 = wires[i][1] - 1;
            
            visited = new boolean[n];
            
            linkedList.get(v1).remove(Integer.valueOf(v2));
            linkedList.get(v2).remove(Integer.valueOf(v1));
            
            int cnt = dfs(0);
            
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
            
            linkedList.get(v1).add(v2);
            linkedList.get(v2).add(v1);
        }
        
        return answer;
    }
    
    // 연결되어 있는 송전탑 개수 카운트
    static int dfs(int i) {
        visited[i] = true;
        int result = 1;
        
        for (int next : linkedList.get(i)) {
            if (!visited[next]) {
                result += dfs(next);
            }
        }
        
        return result;
    }
}