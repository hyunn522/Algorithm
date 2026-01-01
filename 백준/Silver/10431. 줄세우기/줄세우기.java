import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(br.readLine());

        for (int t = 0; t < p; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(Integer.parseInt(st.nextToken())).append(" ");
            int answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < 20; i++) {
                int student = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    pq.offer(student);
                    continue;
                }

                if (student < pq.peek()) {
                    List<Integer> temp = new ArrayList<>();

                    while (!pq.isEmpty() && student < pq.peek()) {
                        temp.add(pq.poll());
                        answer++;
                    }

                    pq.addAll(temp);
                }

                pq.offer(student);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}