import java.util.*;

class Solution {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static List<Integer> answer = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        w = maps.length;
        h = maps[0].length();
        map = new int[w][h];
        visited = new boolean[w][h];
        
        for (int i = 0; i < w; i++) {
            String s = maps[i];
            for (int j = 0; j < h; j++) {
                map[i][j] = s.charAt(j) == 'X' ? -1 : s.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (!visited[i][j] && map[i][j] != -1) {
                    bfs(i, j);
                }
            }
        }
        
        if (answer.isEmpty()) answer.add(-1);
        
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, map[x][y]});
        visited[x][y] = true;
        int result = map[x][y];
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curSum = cur[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
                
                if (!visited[nx][ny] && map[nx][ny] != -1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, curSum + map[nx][ny]});
                    result += map[nx][ny];
                }
            }
        }
        
        answer.add(result);
    }
}