class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] dist = new int[N][N];
        int MAX = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = MAX;
                }
            }
        }
        
        // 가중치까지 저장
        for (int[] arr : road) {
            int a = arr[0] - 1;
            int b = arr[1] - 1;
            int c = arr[2];
            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = Math.min(dist[b][a], c);
        }
        
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][k] != MAX && dist[k][j] != MAX) {
                        dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                    }
                }
            }    
        }

        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (dist[0][i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}