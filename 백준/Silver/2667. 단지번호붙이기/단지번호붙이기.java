import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        PriorityQueue<Integer> answers = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int answer = 1;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i, j}); // x좌표, y좌표
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int curX = cur[0];
                        int curY = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = curX + dx[d];
                            int ny = curY + dy[d];

                            if ((nx < 0 || ny < 0 || nx >= n || ny >= n) || visited[nx][ny]) {
                                continue;
                            }

                            if (map[nx][ny] == 1) {
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                                answer++;
                            }
                        }
                    }
                    answers.offer(answer);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answers.size()).append("\n");
        while (!answers.isEmpty()) {
            sb.append(answers.poll()).append("\n");
        }
        System.out.print(sb);
    }
}