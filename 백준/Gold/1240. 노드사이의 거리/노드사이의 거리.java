import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<List<Node>> tree;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        // 양방향 인접 리스트
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());
            tree.get(a).add(new Node(b, distance));
            tree.get(b).add(new Node(a, distance));
        }

        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            result = 0;
            visited = new boolean[n];
            dfs(a, b, 0);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int node, int destination, int distance) {
        visited[node] = true;

        for (Node next : tree.get(node)) {
            if (!visited[next.point]) dfs(next.point, destination, distance + next.distance);
        }

        if (node == destination) result += distance;
    }

    static class Node {
        int point;
        int distance;

        Node(int point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }
}
