import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] area;
    static boolean[][] isVisited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static List<Integer> rains = new ArrayList<>();
    static int currentRain = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        area = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int newRain = Integer.parseInt(st.nextToken());

                // 강수량 저장
                if (!rains.isEmpty()) {
                    if (!rains.contains(newRain)) {
                        rains.add(newRain);
                    }
                } else {
                    rains.add(newRain);
                }

                area[i][j] = newRain;
            }
        }

        for (int i = 0; i < rains.size(); i++) {
            currentRain = rains.get(i);
            isVisited = new boolean[n][n];

            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!isVisited[j][k] && area[j][k] > currentRain) {
                        dfs(j, k);
                        count++;
                    }
                }
            }

            if (count > result) result = count;
        }

        if (result == 0) result = 1;
        
        System.out.println(result);
    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if (!isVisited[nx][ny] && area[nx][ny] > currentRain) {
                dfs(nx, ny);
            }
        }
    }
}
