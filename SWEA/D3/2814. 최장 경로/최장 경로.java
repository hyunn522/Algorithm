import java.util.ArrayList;
import java.util.Scanner;

class Solution {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            graph = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                graph[x].add(y);
                graph[y].add(x);
            }

            answer = 0;
            for (int i = 0; i < n; i++) {
                visited = new boolean[n];
                dfs(i, 1);
            }

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int v, int len) {
        visited[v] = true;
        answer = Math.max(answer, len);

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next, len + 1);
                visited[next] = false;
            }
        }
    }
}