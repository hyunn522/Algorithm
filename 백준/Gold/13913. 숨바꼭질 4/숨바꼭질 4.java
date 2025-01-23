import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int n, k;
    public static boolean[] visited;
    public static int[] parent;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        parent = new int[100001];

        bfs();
    }

    private static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(n, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int sec = node.sec;
            if(x == k) {
                System.out.println(sec);

                Stack<Integer> stack = new Stack<>();
                int i = node.x;
                while(i != n) {
                    stack.push(i);
                    i = parent[i];
                }
                stack.push(n);
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
                return;
            }

            int[] nxList = {x - 1, x * 2, x + 1};
            for (int nx : nxList) {
                if (nx >= 0 && nx <= 100000) {
                    if (!visited[nx]) {
                        queue.offer(new Node(nx, sec + 1));
                        visited[nx] = true;
                        parent[nx] = x;
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
