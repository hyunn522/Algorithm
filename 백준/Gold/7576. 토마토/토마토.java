import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m];
        Queue<int[]> queue = new ArrayDeque<>();

        int emptyCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 0) {
                    emptyCnt++;
                } else if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (emptyCnt == 0) {
            System.out.println(0);
            return;
        }

        int cnt = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (box[nx][ny] != 0) {
                    continue;
                }

                // 토마토가 익은 일수 자체를 box에 저장
                box[nx][ny] = box[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nx, ny});
                cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, box[i][j]);
            }
        }

        // box 값이 1부터 시작이니까 (최대값 - 1)이 정답
        System.out.println(cnt == emptyCnt ? answer - 1 : -1);
    }
}
