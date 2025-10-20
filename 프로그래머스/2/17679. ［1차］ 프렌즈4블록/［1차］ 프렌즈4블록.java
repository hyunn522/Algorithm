class Solution {
    
    static int answer = 0;
    static char[][] game;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 0, 1};
    
    public int solution(int m, int n, String[] board) {
        game = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                game[i][j] = board[i].charAt(j);
            }
        }
        
        while (true) {
            visited = new boolean[m][n];
            int result = 0;
            
            // 1) 비어있지 않은 칸에 대해 2x2 블록 여부 확인
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0;j < n - 1; j++) {
                    if (game[i][j] != '0') {
                        checkAndMask(i, j);
                    }
                }
            }
            
            // 2) 방문된 칸들에 대해 보드에 표시 및 개수 카운트
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        game[i][j] = '0';
                        result++;
                    }
                }
            }
            
            // 3) 더 이상 소거되는 칸이 없으면 끝
            if (result == 0) break;
            answer += result;
            
            // 4) 각 열에 대해 지워진 칸들 채우기
            for (int i = 0; i < n; i++) {
                moveDown(i, m, n);
            }
        }
        
        return answer;
    }
    
    static void checkAndMask(int x, int y) {
        char c = game[x][y];
        for (int i = 1; i < 4; i++) {
            if (game[x + dx[i]][y + dy[i]] != c) return;
        }
        
        // 모두 같은 모양 -> 방문 여부 마스킹
        for (int i = 0; i < 4; i++) {
            visited[x + dx[i]][y + dy[i]] = true;
        }
    }
    
    static void moveDown(int y, int m, int n) {
        int writeIdx = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (game[i][y] != '0') {
                game[writeIdx--][y] = game[i][y];
            }
        }
        
        // 위쪽 모두 빈 칸으로 채우기
        for (int i = writeIdx; i >= 0; i--) {
            game[i][y] = '0';
        }
    }
}