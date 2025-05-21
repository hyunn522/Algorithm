import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[100];

            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                Arrays.sort(arr);
                if (arr[99] - arr[0] > 1) {
                    arr[99]--;
                    arr[0]++;
                } else break;
            }

            Arrays.sort(arr);
            sb.append("#" + test_case + " " + (arr[99] - arr[0]) + "\n");
        }

        System.out.println(sb);
    }
}