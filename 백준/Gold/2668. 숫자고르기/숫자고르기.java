import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] graph = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        TreeSet<Integer> result = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            boolean isCycle = false;
            List<Integer> answers = new ArrayList<>(); // 사이클 이루는 노드들의 리스트
            answers.add(i);
            int next = graph[i];

            while (true) {
                // 사이클 이룸
                if (next == i) {
                    isCycle = true;
                    break;
                }

                // 다음 노드 탐색
                int cnt = answers.size();
                if (cnt < n) {
                    answers.add(next);
                    next = graph[next];
                    continue;
                }

                break;
            }

            if (isCycle) {
                result.addAll(answers);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        while (!result.isEmpty()) {
            sb.append(result.pollFirst()).append("\n");
        }
        System.out.print(sb);
    }
}