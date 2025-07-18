import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> maxIndexes = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{i, num});
                maxIndexes.offer(num);
            }

            int count = 0;
            while (true) {
                int[] cur = queue.poll();

                if (cur[1] == maxIndexes.peek()) { // 제일 큰 값과 같을 때에만 바로 인쇄
                    count++;
                    maxIndexes.poll();
                    if (cur[0] == m) break;
                } else { // 큐의 가장 뒤에 재배치
                    queue.offer(cur);
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}
