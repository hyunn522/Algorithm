import java.util.Scanner;

class Solution {

    static int n, k, answer;
    static int[] arr;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            k = sc.nextInt();
            arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            answer = 0;
            dfs(0, 0);

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int idx, int sum) {
        if (idx == n) {
            if (sum == k) answer++;
            return;
        }

        // 선택한 경우
        dfs(idx + 1, sum + arr[idx]);

        // 선택하지 않은 경우
        dfs(idx + 1, sum);
    }
}