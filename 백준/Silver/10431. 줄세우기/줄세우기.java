import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(br.readLine());

        while (p-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(Integer.parseInt(st.nextToken())).append(" ");

            List<Integer> line = new ArrayList<>();
            int answer = 0;

            for (int i = 0; i < 20; i++) {
                int curStudent = Integer.parseInt(st.nextToken());

                for (int student : line) {
                    if (student > curStudent) {
                        answer++;
                    }
                }

                line.add(curStudent);
                Collections.sort(line);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}