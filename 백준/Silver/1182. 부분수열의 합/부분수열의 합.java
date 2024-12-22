import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int n, s;
    private static int[] arr;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        dfs(0, 0);
        if (s == 0) result--;
        
        System.out.println(result);
    }

    private static void dfs(int start, int sum) {
        if (start == n) {
            if (sum == s) result++;
            return;
        }

        dfs(start + 1, sum + arr[start]);
        dfs(start + 1, sum);
    }
}
