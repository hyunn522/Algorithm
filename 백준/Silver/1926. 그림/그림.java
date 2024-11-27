import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] paper;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static List<Integer> pictures = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0;j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0;j < m; j++) {
                if (!isVisited[i][j] && paper[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }


        pictures.sort(Collections.reverseOrder());
        sb.append(pictures.size()).append("\n");
        sb.append(pictures.isEmpty() ? "0" : pictures.get(0));

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        isVisited[x][y] = true;

        int size = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            x = node[0];
            y = node[1];
            size++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (!isVisited[nx][ny] && paper[nx][ny] == 1) {
                    isVisited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        pictures.add(size);
    }
}
