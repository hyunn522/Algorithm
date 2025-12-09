import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] room;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                room[i][j] = input.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        char c = room[x][y];
        int idx = c == '-' ? 0 : 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int nx = cur[0] + dx[idx];
            int ny = cur[1] + dy[idx];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (room[nx][ny] == c) {
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

}
