import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n, answer;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            answer = 0;
            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(br.readLine()) - 1;
                graph.get(i).add(a);
            }

            dfs(0, 0);
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int cur, int depth) {
        if (cur == n - 1) {
            answer = depth;
            return;
        }

        if (depth == n) {
            return;
        }

        for (int next : graph.get(cur)) {
            dfs(next, depth + 1);
        }
    }
}