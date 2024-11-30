import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int f, s, g, u, d;
    static int[] floors;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        if (s == g) {
            System.out.println(0);
            return;
        }

        // 1 ~ f층
        floors = new int[f + 1];

        bfs(s);

        System.out.println(result == -1 ? "use the stairs" : result);
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        floors[x] = 1;
        int[] dx = {-d, u};

        while (!queue.isEmpty()) {
            int qx = queue.poll();

            for (int i = 0; i < 2; i++) {
                int nx = qx + dx[i];

                if (nx <= 0 || nx > f) continue;

                if (nx == g) {
                    result = floors[qx];
                    return;
                }

                if (floors[nx] == 0) {
                    queue.offer(nx);
                    floors[nx] = floors[qx] + 1;
                }
            }
        }
    }
}
