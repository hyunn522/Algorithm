import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i][0] = m;
            jewels[i][1] = v;
        }

        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 보석 : 무게 기준 오름차순
        Arrays.sort(jewels, Comparator.comparingInt(j -> j[0]));

        // 가방 : 무게 기준 오름차순
        Arrays.sort(bags);

        // 작은 가방부터 보면서 담을 수 있는 보석 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (idx < n && jewels[idx][0] <= bags[i]) {
                pq.offer(jewels[idx][1]);
                idx++;
            }

            // 현재 가능한 보석 중 가장 비싼 보석 선택
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
