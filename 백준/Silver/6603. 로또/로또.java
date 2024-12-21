import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<int[]> cases;
    private static boolean[] visited;
    private static int[] result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        visited = new boolean[13];
        result = new int[6];
        cases = new ArrayList<>();
        int count = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            cases.add(arr);
            count++;
        }
        br.close();

        for (int i = 0; i < cases.size(); i++) {
            dfs(i, 0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int caseNum, int start, int depth) {
        if (depth == 6) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < cases.get(caseNum).length; i++) {
            if (!visited[i]) {
                result[depth] = cases.get(caseNum)[i];
                dfs(caseNum, i + 1, depth + 1);
            }
        }
    }

}
