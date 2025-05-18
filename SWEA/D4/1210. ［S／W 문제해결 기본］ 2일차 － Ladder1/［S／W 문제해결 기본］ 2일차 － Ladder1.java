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
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int answer = 0;
            for (int i = 0; i < 100; i++) {
                if (map[0][i] == 0) continue; // 시작 점이 사다리가 아닌 경우

                // 사다리 출발
                int cur = i;
                for (int j = 0; j < 100; j++) {
                    if (j == 99) {
                        if (map[j][cur] == 2) answer = i;
                        break;
                    }

                    // 가능하다면 좌우 방향으로 이동
                    if (cur > 0 && cur < 99) {
                        if (map[j][cur - 1] == 1) {
                            while (cur > 0 && map[j][cur - 1] == 1) {
                                cur--;
                            }
                        } else if (map[j][cur + 1] == 1) {
                            while (cur < 99 && map[j][cur + 1] == 1) {
                                cur++;
                            }
                        }
                    } else if (cur == 0 && map[j][cur + 1] == 1) {
                        while (cur < 99 && map[j][cur + 1] == 1) {
                            cur++;
                        }
                    } else if (cur == 99 && map[j][cur - 1] == 1) {
                        while (cur > 0 && map[j][cur - 1] == 1) {
                            cur--;
                        }
                    }
                }
            }

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }
}