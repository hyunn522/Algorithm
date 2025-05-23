import java.util.Scanner;

class Solution {

    static final int SIZE = 100;
    static int[][] table;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();
            table = new int[SIZE][SIZE];

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    table[i][j] = sc.nextInt();
                }
            }

            int answer = 0;

            for (int i = 0; i < SIZE; i++) {
                boolean hasN = false;
                for (int j = 0; j < SIZE; j++) { // 위 -> 아래로 탐색
                    if (table[j][i] == 1) { // N극 자성체
                        hasN = true;
                    } else if (table[j][i] == 2) { // S극 자성체
                        if (hasN) {
                            answer++;
                            hasN = false;
                        }
                    }
                }
            }

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }
}