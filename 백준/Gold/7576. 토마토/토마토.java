import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static int[][] box;
    static boolean[][] visited;
    static int[] dn = {-1, 1, 0, 0, 0, 0};
    static int[] dm = {0, 0, -1, 1, 0, 0};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        visited = new boolean[n][m];

        boolean isAllDone = true;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                String inputs = st.nextToken();
                int tomato = inputs.length() == 1 ? Integer.parseInt(inputs) : -1;
                if (tomato != 1) isAllDone = false;
                if (tomato == 1) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
                box[i][j] = tomato;
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
                int nn = current.n + dn[i];
                int nm = current.m + dm[i];

                if (nn < 0 || nm < 0 || nn >= n || nm >= m) continue;

                if (box[nn][nm] == -1) continue;

                if (!visited[nn][nm] && box[nn][nm] == 0) {
                    visited[nn][nm] = true;
                    box[nn][nm] = 1;
                    result = current.count + 1;
                    queue.offer(new Node(nn, nm, result));
                }
            }
        }

        // 익지 않은 토마토 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }

        return result;
    }

    private static class Node {
        int n;
        int m;
        int count;

        public Node(int n, int m, int count) {
            this.n = n;
            this.m = m;
            this.count = count;
        }
    }
}
