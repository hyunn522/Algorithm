import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n, h;
    static int[][][] box;
    static boolean[][][] visited;
    // 상하좌우 + 위/아래층
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[] dn = {-1, 1, 0, 0, 0, 0};
    static int[] dm = {0, 0, -1, 1, 0, 0};
    static Node start;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        box = new int[h][n][m];
        visited = new boolean[h][n][m];

        boolean isAllDone = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    String inputs = st.nextToken();
                    int tomato = inputs.length() == 1 ? Integer.parseInt(inputs) : -1;
                    if (tomato != 1) isAllDone = false;
                    if (tomato == 1) {
                        queue.add(new Node(i, j, k, 0));
                        visited[i][j][k] = true;
                    }
                    box[i][j][k] = tomato;
                }
            }
        }
        br.close();

        if (isAllDone) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        int result = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nh = current.h + dh[i];
                int nn = current.n + dn[i];
                int nm = current.m + dm[i];

                if (nh < 0 || nn < 0 || nm < 0 || nh >= h || nn >= n || nm >= m) continue;

                if (box[nh][nn][nm] == -1) continue;

                if (!visited[nh][nn][nm] && box[nh][nn][nm] == 0) {
                    visited[nh][nn][nm] = true;
                    box[nh][nn][nm] = 1;
                    result = current.count + 1;
                    queue.offer(new Node(nh, nn, nm, result));
                }
            }
        }

        // 익지 않은 토마토 확인
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return result;
    }

    private static class Node {
        int h;
        int n;
        int m;
        int count;

        public Node(int h, int n, int m, int count) {
            this.h = h;
            this.n = n;
            this.m = m;
            this.count = count;
        }
    }
}
