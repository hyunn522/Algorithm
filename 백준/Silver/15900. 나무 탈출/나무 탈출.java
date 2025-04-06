import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int n;
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        // 양방향 인접 리스트
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(0, 0);
        System.out.println(result % 2 == 0 ? "No" : "Yes");
    }

    private static void dfs(int node, int cnt) {
        visited[node] = true;

        for (int next : tree.get(node)) {
            if (!visited[next]) dfs(next, cnt + 1);
        }

        if (node != 0 && tree.get(node).size() == 1) result += cnt;
    }

}
