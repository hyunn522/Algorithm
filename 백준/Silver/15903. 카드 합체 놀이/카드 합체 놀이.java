import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(st.nextToken());
            pq.add(num);
            answer += num;
        }

        for (int i = 0; i < m; i++) {
            long sum = pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
            answer += sum;
        }

        System.out.println(answer);
    }
}
