import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<int[]> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items.add(new int[]{w, v});
        }

        int[] dp = new int[k + 1]; // 무게가 i일 때의 최대 가치
        for (int[] item : items) {
            int curW = item[0];
            int curV = item[1];
            for (int w = k; w >= curW; w--) {
                dp[w] = Math.max(dp[w], dp[w - curW] + curV);
            }
        }

        System.out.println(dp[k]);
    }
}
