import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n][n];
        
        for(int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                if (!visited[i][j] && computers[i][j] == 1) {
                    dfs(computers, j, i, n);
                    result++;
                }
            }
        }
        
        return result;
    }
    
    public void dfs(int[][] computers, int x, int y, int n) {
        visited[y][x] = true;
        visited[x][y] = true;
        
        // 컴퓨터 x와 y가 연결돼있음 -> x와 연결 + y와 연결
        int[] connectionX = computers[x];
        int[] connectionY = computers[y];
        
        for (int i = 0; i < n; i++) {
            if (!visited[x][i] && connectionX[i] == 1) {
                dfs(computers, i, x, n);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[y][i] && connectionY[i] == 1) {
                dfs(computers, y, i, n);
            }
        }
        
//         for (int i = 0;i < 4; i++) {
//             int nx = x + dx[i];
//             int ny = y + dy[i];
            
//             if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            
//             if (!visited[ny][nx] && computers[ny][nx] == 1) {
//                 dfs(computers, nx, ny, n);
//             }
//         }
    }
}