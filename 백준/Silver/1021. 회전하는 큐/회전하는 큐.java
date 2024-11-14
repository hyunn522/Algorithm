import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer firstInput = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(firstInput.nextToken());
        int m = Integer.parseInt(firstInput.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        List<Integer> targetNums = new ArrayList<>();

        StringTokenizer secondInput = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targetNums.add(Integer.parseInt(secondInput.nextToken()));
        }

        int result = 0;
        for (int targetNum : targetNums) {
            int index = 0;
            for (int num : deque) {
                if (num == targetNum) {
                    break;
                }
                index++;
            }

            int leftOffset = index;
            int rightOffset = deque.size() - index;

            if (leftOffset <= rightOffset) {
                for (int i = 0; i < leftOffset; i++) {
                    deque.addLast(deque.pollFirst());
                    result++;
                }
            } else {
                for (int i = 0; i < rightOffset; i++) {
                    deque.addFirst(deque.pollLast());
                    result++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(result);
    }
}
