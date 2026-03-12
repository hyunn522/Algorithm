import java.io.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            // {선수 번호, 포인트}
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<int[]> ranks = new PriorityQueue<>((r1, r2) -> r2[1] - r1[1]);

            if (n == 0 || m == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }

            for (Entry<Integer, Integer> e : map.entrySet()) {
                ranks.offer(new int[]{e.getKey(), e.getValue()});
            }

            ranks.poll(); // 1등 (할아버지)
            PriorityQueue<Integer> seconds = new PriorityQueue<>(); // 2등 선수 번호
            int[] second = ranks.poll(); // 2등
            seconds.offer(second[0]);
            
            while (!ranks.isEmpty()) {
                int[] cur = ranks.poll();
                if (second[1] == cur[1]) { // 2등과 동점인 경우
                    seconds.offer(cur[0]);
                } else {
                    break;
                }
            }

            while (!seconds.isEmpty()) {
                sb.append(seconds.poll()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}