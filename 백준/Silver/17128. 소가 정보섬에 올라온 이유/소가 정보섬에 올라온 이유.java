import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] cows;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        cows = new int[n];
        List<Integer> targets = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            targets.add(Integer.parseInt(st.nextToken()) - 1);
        }

        int[] results = new int[n]; // i번째 소로부터 시작하는 합
        int sum = 0;
        for (int i = 0; i < n; i++) {
            results[i] = calculateSum(i);
            sum += results[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            // 스티커 바꿈
            cows[target] *= -1;

            // target - 3, target - 2, target - 1, target번째부터 시작하는 합 갱신
            for (int j = 0; j < 4; j++) {
                int i = (target - 3 + n + j) % n;
                int original = results[i];
                results[i] = calculateSum(i);
                sum += results[i] - original;
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    private static int calculateSum(int start) {
        return cows[start % n] * cows[(start + 1) % n] * cows[(start + 2) % n] * cows[(start + 3) % n];
    }
}