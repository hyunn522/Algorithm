import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static boolean[] visited;
    private static int[] result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        br.close();

        visited = new boolean[n];
        result = new int[n];

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }

        }
    }

}
