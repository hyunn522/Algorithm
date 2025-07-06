import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        times = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        int[] dp = new int[n];
        int answer = times[0];
        dp[0] = times[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + times[i];
            answer += dp[i];
        }
        System.out.println(answer);
    }
}
