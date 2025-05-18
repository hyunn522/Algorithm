import java.util.Scanner;

class Solution
{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt(); // 테스트 케이스 번호

            int[][] map = new int[100][100]; // 사다리
            int x = -1;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] == 2) x = j;
                }
            }

            // 도착점에서부터 거꾸로 거슬러올라가기
            int h = 99;
            while (h > 0) {
                if (x > 0 && map[h][x - 1] == 1) {
                    while (x > 0 && map[h][x - 1] == 1) x--;
                } else if (x < 99 && map[h][x + 1] == 1) {
                    while (x < 99 && map[h][x + 1] == 1) x++;
                }

                h--;
            }

            sb.append("#" + test_case + " " + x + "\n");
        }

        System.out.println(sb);
    }
}