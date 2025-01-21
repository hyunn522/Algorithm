import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n, k;
    public static boolean[] visited;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        bfs();
    }

    private static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int sec = node.sec;
            visited[x] = true;
            if (x == k) {
                System.out.println(sec);
                return;
            }

            int[] allX = {x * 2, x - 1, x + 1};
            for (int nx : allX) {
                if (nx >= 0 && nx <= 100000) {
                    if (!visited[nx]) {
                        visited[nx] = true;
                        if (nx == x * 2) {
                            queue.offer(new Node(nx, sec));
                        } else {
                            queue.offer(new Node(nx, sec + 1));
                        }
                    }
                }
            }
        }
    }

    private static class Node {
        int x;
        int sec;

        public Node(int x, int sec) {
            this.x = x;
            this.sec = sec;
        }
    }

}
