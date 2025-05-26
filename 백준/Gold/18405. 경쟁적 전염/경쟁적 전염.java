import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        Set<List<Integer>> tempPoints = new HashSet<>();

        int emptyCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) emptyCnt++;
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        boolean done = false;
        while (s > 0) {
            for (int v = 1; v <= k; v++) { // 번호가 작은 바이러스부터 증식
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] == v) {
                            for (int d = 0; d < 4; d++) {
                                int nx = i + dx[d];
                                int ny = j + dy[d];

                                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                                if (map[nx][ny] == 0) tempPoints.add(Arrays.asList(nx, ny)); // map에 바로 반영하면 안됨
                            }
                        }
                    }
                }

                for (List<Integer> points : tempPoints) { // map에 반영
                    map[points.get(0)][points.get(1)] = v;
                    emptyCnt--;
                }

                if (emptyCnt <= 0) done = true; // 더이상 빈 칸이 없을 때 반복 끝냄

                tempPoints.clear(); // 증식할 칸 초기화
            }

            if (done) break;

            s--;
        }

        System.out.println(map[x][y]);
    }
}