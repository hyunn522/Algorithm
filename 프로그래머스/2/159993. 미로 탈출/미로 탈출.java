import java.util.*;

class Solution {
    
    static int row, col, startX, startY, leverX, leverY;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        board = new char[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    leverX = i;
                    leverY = j;
                }
                
                board[i][j] = c;
            }
        }
        
        visited = new boolean[row][col];
        int first = bfs(false);
        if (first <= 0) {
            return -1;
        }
        
        visited = new boolean[row][col];
        int second = bfs(true);
        if (second <= 0) {
            return -1;
        }
        
        return first + second;
    }
    
    static int bfs(boolean isLeverStart) {
        Queue<int[]> queue = new ArrayDeque<>(); // {x좌표, y좌표, 거리}
        if (isLeverStart) {
            queue.offer(new int[]{leverX, leverY, 0});
            visited[leverX][leverY] = true;
        } else {
            queue.offer(new int[]{startX, startY, 0});
            visited[startX][startY] = true;
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curDist = cur[2];
            
            if (isLeverStart) {
                if (board[curX][curY] == 'E') {
                    return curDist;
                }
            } else {
                if (board[curX][curY] == 'L') {
                    return curDist;
                }
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    continue;
                }
                
                if (!visited[nx][ny] && board[nx][ny] != 'X') {
                    queue.offer(new int[]{nx, ny, curDist + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}