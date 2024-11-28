import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int m, n, k;
    static int[][] paper;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int size = 0;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        paper = new int[m][n];
        isVisited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int leftBottomX = Integer.parseInt(st.nextToken());
            int leftBottomY = Integer.parseInt(st.nextToken());
            int rightTopX = Integer.parseInt(st.nextToken());
            int rightTopY = Integer.parseInt(st.nextToken());

            for (int j = leftBottomY; j < rightTopY; j++) {
                for (int l = leftBottomX; l < rightTopX; l++) {
                    paper[j][l] = 1;
                }
            }
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && paper[i][j] == 0) {
                    size++;
                    dfs(i, j);
                    result.add(size);
                    size = 0;
                }
            }
        }

        StringBuilder printResult = new StringBuilder();
        Collections.sort(result);
        for (Integer integer : result) {
            printResult.append(integer).append(" ");
        }
        System.out.println(result.size());
        System.out.println(printResult.toString().trim());

    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

            if (!isVisited[nx][ny] && paper[nx][ny] == 0) {
                size++;
                dfs(nx, ny);
            }
        }
    }
}
