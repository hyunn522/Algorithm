import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt(); // m초 동안 k개 만들 수 있음
            int[] times = new int[n];
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                times[i] = sc.nextInt();
            }
            Arrays.sort(times);

            for (int i = 0; i < n; i++) {
                int time = times[i];
                int fish = (time / m) * k;
                
                if (fish < i + 1) { // 현재 손님 수보다 붕어빵이 더 적으면 불가
                    isPossible = false;
                    break;
                }
            }

            sb.append("#" + test_case + " " + (isPossible ? "Possible" : "Impossible") + "\n");
        }

        System.out.println(sb);
    }
}