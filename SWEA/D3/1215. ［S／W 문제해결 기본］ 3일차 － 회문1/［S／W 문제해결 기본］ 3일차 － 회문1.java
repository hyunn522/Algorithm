import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {

    static int n, answer;
    static int[][] map;
    static final int SIZE = 8;
    static final int[] dx = {0, 1};
    static final int[] dy = {1, 0};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            map = new int[SIZE][SIZE];

            for (int i = 0; i < SIZE; i++) {
                String input = sc.next();
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = input.charAt(j) - 'A';
                }
            }

            answer = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    dfs(i, j);
                }
            }

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        for (int dir = 0; dir < 2 ; dir++) {
            int endX = x + (n - 1) * dx[dir];
            int endY = y + (n - 1) * dy[dir];

            if (endX < 0 || endY < 0 || endX >= SIZE || endY >= SIZE) continue;

            Deque<Integer> stack = new LinkedList<>();
            boolean isPalindrome = true;

            for (int i = 0; i < n; i++) {
                int cur = map[x + i * dx[dir]][y + i * dy[dir]];

                if (i < n / 2) stack.push(cur);
                else if (n % 2 == 1 && i == n / 2) { // n이 홀수일 때 중간 무시
                    continue;
                } else {
                    if (stack.isEmpty() || stack.pop() != cur) {
                        isPalindrome = false;
                        break;
                    }
                }
            }

            if (isPalindrome) answer++;
        }

    }
}