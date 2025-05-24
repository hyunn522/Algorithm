import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

    static final int SIZE = 8;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < SIZE; i++) {
                queue.offer(Integer.parseInt(sc.next()));
            }

            boolean isDone = false;
            do {
                for (int i = 1; i <= 5; i++) {
                    int next = queue.poll() - i;
                    queue.offer(Math.max(next, 0));

                    if (next <= 0) {
                        isDone = true;
                        break;
                    }
                }
            } while (!isDone);

            String answer = "";
            for (int i : queue) {
                answer += i + " ";
            }
            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }
}