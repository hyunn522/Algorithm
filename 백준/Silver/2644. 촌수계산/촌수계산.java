import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int a, b;
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[n];
        result = new int[n];

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()) - 1;
        b = Integer.parseInt(st.nextToken()) - 1;

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        int answer = bfs();
        System.out.println(answer == 0 ? -1 : answer);
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(a, 0));
        visited[a] = true;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.cur == b) break;

            for (int next : tree.get(curNode.cur)) {
                if (!visited[next]) {
                    queue.offer(new Node(next, curNode.dist + 1));
                    visited[next] = true;
                    result[next] = curNode.dist + 1;
                }
            }
        }

        return result[b];
    }

    static class Node {
        int cur;
        int dist;

        Node(int cur, int dist) {
            this.cur = cur;
            this.dist = dist;
        }
    }
}
