import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            int num = queue.poll();
            sb.append(num + " ");
            queue.offer(queue.poll());
        }

        sb.append(queue.poll());
        System.out.println(sb);
    }
}
