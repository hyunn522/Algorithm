import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, s, answer = 0;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (s == 0) {
            answer--;
        }

        System.out.println(answer);
    }

    private static void dfs(int idx, int sum) {
        if (idx == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }

        dfs(idx + 1, sum + nums[idx]); // idx 선택
        dfs(idx + 1, sum); // idx 선택 X
    }
}