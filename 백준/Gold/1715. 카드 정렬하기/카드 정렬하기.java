import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + b;
            answer += sum;
            pq.offer(sum);
        }

        System.out.println(answer);
    }
}