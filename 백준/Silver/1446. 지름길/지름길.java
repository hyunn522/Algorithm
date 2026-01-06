import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] dp = new int[d + 1];
        List<int[]>[] shorts = new ArrayList[d + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= d; i++) {
            shorts[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (start >= d || end > d || dist >= end - start) {
                continue;
            }

            shorts[start].add(new int[]{end, dist});
        }

        for (int i = 0; i <= d; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }

            for (int[] road : shorts[i]) {
                int end = road[0];
                int dist = road[1];
                if (dp[i] + dist < dp[end]) {
                    dp[end] = dp[i] + dist;
                }
            }
        }

        System.out.println(dp[d]);
    }
}