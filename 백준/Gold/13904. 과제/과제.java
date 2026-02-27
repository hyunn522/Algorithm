import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 마감일 기준으로 묶어서 저장
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            list.add(new ArrayList<>());
        }

        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(d).add(w);
            maxDay = Math.max(maxDay, d);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        for (int day = maxDay; day >= 1; day--) {
            // 해당 날짜에 마감인 과제 추가
            for (int w : list.get(day)) {
                pq.offer(w);
            }

            // 가능한 과제 중 가장 점수가 큰 것 선택
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}