import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 절댓값 기준으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((x1, x2) -> {
            int absX1 = Math.abs(x1);
            int absX2 = Math.abs(x2);

            if (absX1 != absX2) {
                return absX1 - absX2;
            } else {
                return x1 - x2;
            }
        });

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(x);
            } else {
                if (pq.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(pq.poll() + "\n");
                }
            }
        }

        System.out.println(sb);
    }
}