import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rightPq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(br.readLine());

            if (leftPq.size() == rightPq.size()) {
                leftPq.offer(input);
            } else {
                rightPq.offer(input);
            }

            if (!rightPq.isEmpty() && leftPq.peek() > rightPq.peek()) {
                int l = leftPq.poll();
                int r = rightPq.poll();
                leftPq.offer(r);
                rightPq.offer(l);
            }

            sb.append(leftPq.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
