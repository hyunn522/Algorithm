import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static char[][] abnormalArea;
    static char[][] normalArea;
    static boolean[][] isVisited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        abnormalArea = new char[n][n];
        normalArea = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] inputs = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                normalArea[i][j] = inputs[j];
                // 적록색약의 경우 G를 R로 묶어서 고려
                abnormalArea[i][j] = (inputs[j] == 'G') ? 'R' : inputs[j];
            }
        }
        br.close();

        int abnormalResult = countResult(abnormalArea);
        int normalResult = countResult(normalArea);

        sb.append(normalResult + " " + abnormalResult);
        System.out.println(sb);
    }

    private static int countResult(char[][] area) {
        int result = 0;
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j, area, area[i][j]);
                    result++;
                }
            }
        }

        return result;
    }

    private static void dfs(int x, int y, char[][] area, char prev) {
        isVisited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if (!isVisited[nx][ny] && area[nx][ny] == prev) {
                dfs(nx, ny, area, prev);
            }
        }
    }
}
