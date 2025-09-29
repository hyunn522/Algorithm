import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                // 아이들 만남
                sb.append(pq.isEmpty() ? -1 : pq.poll()).append("\n");
            } else {
                for (int j = 0; j < a; j++) {
                    // 선물 충전
                    while (st.hasMoreTokens()) {
                        pq.offer(Integer.parseInt(st.nextToken()));
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
