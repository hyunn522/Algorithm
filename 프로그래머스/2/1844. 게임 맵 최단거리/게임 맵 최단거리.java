import java.util.*;

class Node {
    private int x;    
    private int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    int getX() {
        return this.x;
    }
    
    int getY() {
        return this.y;
    }
}

class Solution {
    int answer = 0;
    // 상하좌우에 대한 방향
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // // 상대 팀 진영의 상, 좌에 대해 0이면 -1 반환
        // if (maps[n - 2][m - 1] == 0 && maps[n  - 1][m - 2] == 0) return -1;
        
        // 최단거리 -> bfs
        return bfs(maps, 0, 0, n, m);
    }
    
    public int bfs(int[][] maps, int x, int y, int n, int m) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(x, y));
        
        while(!queue.isEmpty()) {
            Node first = queue.poll();
            int firstX = first.getX();
            int firstY = first.getY();
            for (int i = 0; i < 4;i++) {
                int newX = firstX + dx[i];
                int newY = firstY + dy[i];
                // 유효하지 않은 위치인 경우
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
                // 벽인 경우
                if (maps[newX][newY] == 0) continue;
                // 방문하지 않은 경로인 경우
                if (maps[newX][newY] == 1) {
                    // 최단거리 갱신
                    maps[newX][newY] = maps[firstX][firstY] + 1;
                    queue.offer(new Node(newX, newY));
                }
            }
        }
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
}