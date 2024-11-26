import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static public int n, m, k;
    static public int[][] cabbage;
    static boolean[][] isVisit;
    static int count;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0;i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            cabbage = new int[m][n];
            isVisit = new boolean[m][n];

            k = Integer.parseInt(st.nextToken());
            for (int j = 0;j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int tmpN = Integer.parseInt(st.nextToken());
                int tmpM = Integer.parseInt(st.nextToken());
                cabbage[tmpN][tmpM] = 1;
            }

            count = 0;
            for (int x = 0; x < m; x++){
                for (int y = 0; y < n; y++){
                    if (cabbage[x][y] == 1 && !isVisit[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
            sb.append(count + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        isVisit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < m && cy < n) {
                if (!isVisit[cx][cy] && cabbage[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }
        }
    }
}
