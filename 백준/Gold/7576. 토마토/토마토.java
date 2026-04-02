import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> tomatoes = new ArrayDeque<>();

        // 익지 않은 토마토의 개수
        int emptyCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 0) { // 익지 않은 토마토의 경우
                    emptyCnt++;
                } else if (box[i][j] == 1) { // 익은 토마토의 경우
                    tomatoes.offer(new int[]{i, j});
                }
            }
        }

        // 저장될 때부터 모든 토마토가 익어있는 경우
        if (emptyCnt == 0) {
            System.out.println(0);
            return;
        }

        int cnt = 0; // 익은 토마토의 총 개수
        int answer = 0;

        while (!tomatoes.isEmpty()) {
            int size = tomatoes.size(); // 현재 날짜의 토마토 개수
            for (int s = 0; s < size; s++) {
                int[] cur = tomatoes.poll();
                int curX = cur[0];
                int curY = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }

                    if (!visited[nx][ny] && box[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        tomatoes.offer(new int[]{nx, ny});
                        cnt++;
                    }
                }
            }

            if (cnt > 0 && !tomatoes.isEmpty()) {
                answer++;
            }
        }
        
        System.out.println(cnt == emptyCnt ? answer : -1);
    }
}