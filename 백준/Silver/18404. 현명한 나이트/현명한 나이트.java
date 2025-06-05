import java.io.*;
import java.util.*;

public class Main {

    static int n, m, x, y;
    static List<List<Integer>> destinations; // 상대편 말의 좌표들
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] result;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        destinations = new ArrayList<>();
        result = new int[m];
        Arrays.fill(result, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            destinations.add(List.of(a, b));
        }

        bfs();

        String answer = "";
        for (int i : result) {
            answer += i + " ";
        }
        System.out.println(answer);
    }

    private static void bfs() {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curDepth = cur[2];

            if (destinations.contains(List.of(curX, curY))) { // 상대편 말인 경우
                int idx = destinations.indexOf(List.of(curX, curY));
                result[idx] = Math.min(result[idx], curDepth);
            }
            
            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (!visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny, curDepth + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}