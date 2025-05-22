import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            char[] original = sc.next().toCharArray();

            char cur = '0';
            int answer = 0;
            for (int i = 0; i < original.length; i++) {
                if (original[i] == '1' && cur == '0') {
                    answer++;
                    cur = '1';
                } else if (original[i] == '0' && cur == '1') {
                    answer++;
                    cur = '0';
                }
            }

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }
}