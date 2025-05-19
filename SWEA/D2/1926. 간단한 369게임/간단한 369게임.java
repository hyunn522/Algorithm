import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            boolean isExist = false;

            char[] charArray = String.valueOf(i).toCharArray();
            for (char c : charArray) {
                if (c == '3'|| c == '6' || c == '9') {
                    sb.append("-");
                    isExist = true;
                }
            }

            if (isExist) {
                sb.append(" ");
                continue;
            }

            sb.append(i + " ");
        }

        System.out.println(sb);
    }
}