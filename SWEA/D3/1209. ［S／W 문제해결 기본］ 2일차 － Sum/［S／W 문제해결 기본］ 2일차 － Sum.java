import java.util.Scanner;

class Solution {

    static int answer;
    static int[][] arr;

    static final int SIZE = 100;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();
            arr = new int[SIZE][SIZE];

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            answer = Integer.MIN_VALUE;

            // case 1) 각 행의 합
            for (int i = 0; i < SIZE; i++) {
                int sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    sum += arr[i][j];
                }
                answer = Math.max(answer, sum);
            }

            // case 2) 각 열의 합
            for (int i = 0; i < SIZE; i++) {
                int sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    sum += arr[j][i];
                }
                answer = Math.max(answer, sum);
            }

            // case 3) 두 대각선의 합
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < SIZE; i++) {
                sum1 += arr[i][i];               // 오른쪽 아래 대각선
                sum2 += arr[i][SIZE - 1 - i];    // 왼쪽 아래 대각선
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }
}