import java.io.*;

public class Main {

    static int n, totalCnt;
    static int[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        int maxCnt = -1;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            totalCnt = 0;

            dfs(i);

            if (totalCnt > maxCnt) {
                maxCnt = totalCnt;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        totalCnt++;

        int next = graph[cur];

        if (!visited[next]) {
            dfs(next);
        }
    }
}