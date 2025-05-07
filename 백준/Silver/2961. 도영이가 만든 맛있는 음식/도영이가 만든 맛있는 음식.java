import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, answer = Integer.MAX_VALUE;
    static int[][] tastes;
    static List<Integer> used;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tastes = new int[n][2];
        used = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tastes[i][0] = s;
            tastes[i][1] = b;
        }

        dfs(0);
        
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            if (!used.isEmpty()) {
                int s = 1, b = 0;
                for (int i : used) {
                    s *= tastes[i][0];
                    b += tastes[i][1];
                }
                int diff = Math.abs(s - b);
                answer = Math.min(answer, diff);
            }
            return;
        }

        // case 1) 해당 재료를 사용하지 않는 경우
        dfs(depth + 1);

        // case 2) 해당 재료를 사용하는 경우
        used.add(depth);
        dfs(depth + 1);
        used.remove((Integer)depth);
    }

}
