import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, answer;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) bfs(i, j);
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;
        int result = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int curX = curNode.x;
            int curY = curNode.y;

            if (map[curX][curY] == 1) {
                result = curNode.dist;
                break;
            }

            result++;

            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.add(new Node(nx, ny, curNode.dist + 1));
            }
        }

        answer = Math.max(answer, result);
    }

    static class Node {
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}
