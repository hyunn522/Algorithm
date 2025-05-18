import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt(); // 건물의 개수
            int[] map = new int[n]; // 각 건물들의 높이 저장
            for (int i = 0; i < n; i++) {
                map[i] = sc.nextInt();
            }

            int answer = 0;
            for (int w = 2; w < n - 2; w++) {
                int maxNeighbor = Math.max(
                        Math.max(map[w - 1], map[w - 2]),
                        Math.max(map[w + 1], map[w + 2]));

                if (map[w] > maxNeighbor) {
                    answer += map[w] - maxNeighbor;
                }
            }

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }
}