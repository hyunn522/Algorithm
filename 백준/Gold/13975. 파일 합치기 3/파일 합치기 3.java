import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int k = Integer.parseInt(br.readLine());
            // 작은 숫자일수록 앞 순서에 더해져야 전체 합이 최소가 됨
            PriorityQueue<Long> pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long answer = 0;
            while (pq.size() > 1) {
                long sum = pq.poll() + pq.poll();
                answer += (sum);
                pq.add(sum);
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }
}
