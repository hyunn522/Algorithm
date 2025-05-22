import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] farm = new int[n][n];

            for (int i = 0; i < n; i++) {
                String input = sc.next();
                for (int j = 0; j < n; j++) {
                    farm[i][j] = input.charAt(j) - '0';
                }
            }

            int answer = 0;
            int middle = n / 2;
            for (int i = 0; i < n; i++) {
                if (i == middle) {
                    for (int j = 0; j < n; j++) {
                        answer += farm[j][i];
                    }
                    continue;
                }

                if (i < middle) {
                    for (int j = middle - i ; j < n - (middle - i); j++) {
                        answer += farm[j][i];
                    }
                } else {
                    for (int j = i - middle; j < n - (i - middle); j++) {
                        answer += farm[j][i];
                    }
                }
            }

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }
}