import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int n;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static List<Integer> houses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] inputs = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = inputs[j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    houses.add(dfs(i, j));
                }
            }
        }

        Collections.sort(houses);
        sb.append(houses.size() + "\n");
        for (int house : houses) {
            sb.append(house + "\n");
        }
        System.out.println(sb);
    }

    static int dfs(int x, int y) {
        int result = 1;
        map[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if (map[nx][ny] == 1) {
                result += dfs(nx, ny);
            }
        }

        return result;
    }
}
