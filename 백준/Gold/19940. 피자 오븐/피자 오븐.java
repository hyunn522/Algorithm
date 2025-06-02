import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] best = null;

            int cnt0 = n / 60; // +60 기본 횟수
            for (int plus60 = cnt0; plus60 <= cnt0 + 1; plus60++) {
                int mod = n - plus60 * 60; // +60 후 남은 시간
                // 가능한 +-10 연산 모두 수행
                for (int plus10 = 0; plus10 < 6; plus10++) {
                    for (int minus10 = 0; minus10 < 6; minus10++) {
                        int diff = mod - (plus10 * 10) + (minus10 * 10);
                        if (Math.abs(diff) >= 10) continue;

                        // 가능한 +-1 연산 모두 수행
                        int plus1 = Math.max(0, diff);
                        int minus1 = Math.max(0, -diff);

                        int[] cur = new int[]{plus60, plus10, minus10, plus1, minus1};
                        if (best == null || better(cur, best)) best = cur;
                    }
                }

            }

            for (int i : best) sb.append(i + " ");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean better(int[] a, int[] b) {
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        if (sumA != sumB) return sumA < sumB; // 총합이 적은 게 best

        for (int i = 0; i < 5; i++) {
            if (a[i] != b[i]) return a[i] < b[i];  // 총합이 같다면 사전순으로 작은 게 best
        }
        return false;
    }
}