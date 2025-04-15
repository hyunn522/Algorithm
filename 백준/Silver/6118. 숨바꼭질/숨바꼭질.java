import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static List<List<Integer>> graph; // 인접 리스트
    static boolean[] visited;
    static int[] cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n];
        cost = new int[n];
        
        for (int i = 0; i < n ;i++) {
            graph.add(new ArrayList<>());
        }
        Arrays.fill(cost, Integer.MIN_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs();

        int maxIdx = -1;
        int maxCost = 0;
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            int c = cost[i];
            if (c > maxCost) {
                maxIdx = i;
                maxCost = c;
                maxNum = 1;
            } else if (c == maxCost) {
                maxNum++;
            }
        }

        System.out.println(maxIdx + 1 + " " + maxCost + " " + maxNum);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        visited[0] = true;
        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            cost[cur.point] = cur.dist;

            for (int next : graph.get(cur.point)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, cur.dist + 1));
                }
            }
        }
    }

    static class Node {
        int point, dist;

        Node(int point, int dist) {
            this.point = point;
            this.dist = dist;
        }
    }

}
