import java.util.*;

class Solution {
    public int solution(String dirs) {
        boolean[][][] visited = new boolean[11][11][4];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int curX = 5, curY = 5;
        int answer = 0;
        
        for (char dir : dirs.toCharArray()) {
            int curDir = -1;
            
            switch (dir) {
                case 'U':
                    if (curY + 1 <= 10) curDir = 0;
                    break;
                case 'D':
                    if (curY - 1 >= 0) curDir = 1;
                    break;
                case 'R':
                    if (curX + 1 <= 10) curDir = 2;
                    break;
                case 'L':
                    if (curX - 1 >= 0) curDir = 3;
                    break;
            }
            
            if (curDir != -1) {
                int nextX = curX + dx[curDir];
                int nextY = curY + dy[curDir];
                int oppDir = (curDir % 2 == 0) ? curDir + 1 : curDir - 1;
                
                if (!visited[curX][curY][curDir]) {
                    answer++;
                    visited[curX][curY][curDir] = true;
                    visited[nextX][nextY][oppDir] = true;
                }

                curX = nextX;
                curY = nextY;
            }
        }
        
        return answer;
    }
}