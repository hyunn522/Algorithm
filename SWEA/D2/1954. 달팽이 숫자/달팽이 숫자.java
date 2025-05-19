import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            int dir = 0;
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            int x = 0, y = 0;
            for (int i = 1; i <= n * n; i++) {
                arr[x][y] = i;

                if (x + dx[dir] < 0 || y + dy[dir] < 0 || x + dx[dir] >= n || y + dy[dir] >= n || arr[x + dx[dir]][y + dy[dir]] != 0) {
                    dir = (dir + 1) % 4; // 방향 전환
                }

                x += dx[dir];
                y += dy[dir];
            }

            sb.append("#" + test_case + "\n");
            for (int[] a : arr) {
                for (int i : a) {
                    sb.append(i + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}