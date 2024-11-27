import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static public int l, currentX, currentY, goalX, goalY;
    static public int[][] chess;
    static int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
    static int[] dy = {-2, 2, -2, 2, -1, 1, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0;i < t; i++) {
            l = Integer.parseInt(br.readLine());
            chess = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            currentX = Integer.parseInt(st.nextToken());
            currentY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());
//            chess[goalX][goalY] = 2;

            count = 0;
            if (goalX != currentX || goalY != currentY) {
                count = bfs(currentX, currentY);
            }
            sb.append(count + "\n");
        }

        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        chess[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            x = node[0];
            y = node[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
                if (chess[nx][ny] != 0) continue;

                if (nx == goalX && ny == goalY) {
                    return chess[x][y];
                }

                chess[nx][ny] = chess[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
        return -1;
    }
}
