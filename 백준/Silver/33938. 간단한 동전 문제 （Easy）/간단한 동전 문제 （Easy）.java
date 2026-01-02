import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int OFFSET = 2000;
    static int m;
    static int[] coins;
    static int[] dist = new int[OFFSET * 2 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n == 0) {
            if (m == 0) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            return;
        }

        coins = new int[n];
        Arrays.fill(dist, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coins);

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        dist[OFFSET] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == m) {
                return dist[cur + OFFSET];
            }

            for (int coin : coins) {
                int next = cur + coin;

                if (next + OFFSET >= 0 && next + OFFSET <= 4000) {
                    if (dist[next + OFFSET] == -1) {
                        dist[next + OFFSET] = dist[cur + OFFSET] + 1;
                        queue.offer(next);
                    }
                }
            }

        }

        return -1;
    }
}