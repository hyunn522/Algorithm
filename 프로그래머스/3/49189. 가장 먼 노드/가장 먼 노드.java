import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int[] path : edge) {
            int a = path[0];
            int b = path[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // 1번 노드부터 각 노드까지의 최단 거리 구하기
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1); // 방문 여부 확인 위해 -1로 초기화
        Queue<Integer> queue = new ArrayDeque<>(); 
        queue.offer(1);
        dist[1] = 0;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (dist[next] == -1) { // 방문한 적이 없는 경우
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
        }
        
        int maxDist = Integer.MIN_VALUE;
        for (int d : dist) {
            maxDist = Math.max(maxDist, d);
        }
       
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (dist[i] == maxDist) answer++;
        }
        return answer;
    }
}