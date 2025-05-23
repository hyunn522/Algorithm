import java.util.Scanner;

class Solution {

    static int n, answer;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            answer = 0;
            col = new boolean[n];
            diag1 = new boolean[2 * n - 1];
            diag2 = new boolean[2 * n - 1];

            dfs(0);

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }

    /* row번째 행에 놓음 */
    private static void dfs(int row) {
        if (row == n) { // n개를 놓았으면 완성
            answer++;
            return;
        }

        /* 각 열에 대해 놓을 수 있는지 확인 후 가능하다면 놓음 */
        for (int c = 0; c < n; c++) {
            int d1 = row - c + n - 1;
            int d2 = row + c;

            if (col[c] || diag1[d1] || diag2[d2]) continue;

            col[c] = diag1[d1] = diag2[d2] = true;
            dfs(row + 1);
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}