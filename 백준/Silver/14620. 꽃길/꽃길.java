import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int depth, int cost) {
        if (depth == 3) {
            answer = Math.min(answer, cost);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean possible = !visited[i][j];
                if (!possible) continue;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if ((nx < 0 || ny < 0 || nx >= n || ny >= n) || visited[nx][ny]) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    int newCost = cost + map[i][j];
                    visited[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        visited[nx][ny] = true;
                        newCost += map[nx][ny];
                    }

                    dfs(depth + 1, newCost);

                    visited[i][j] = false;
                    for (int k = 0; k < 4; k++) {
                        visited[i + dx[k]][j + dy[k]] = false;
                    }
                }
            }
        }
    }

}
