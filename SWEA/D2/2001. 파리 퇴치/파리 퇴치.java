import java.util.Scanner;

class Solution {

    static int n, m, answer;
    static int[][] map;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            m = sc.nextInt();
            map = new int[n][n];
            answer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n - m + 1; i++) {
                for (int j = 0; j < n - m + 1; j++) {
                    int sum = 0;
                    for (int dx = 0; dx < m; dx++) {
                        for (int dy = 0; dy < m; dy++) {
                            sum += map[i + dx][j + dy];
                        }
                    }

                    answer = Math.max(answer, sum);
                }
            }

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }
}