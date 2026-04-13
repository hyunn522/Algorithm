import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] graph = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

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
                for (int answer : answers) {
                    visited[answer] = true;
                    result.add(answer);
                }
            }
        }

        Collections.sort(result);
        int size = result.size();

        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\n");
        for (int i = 0; i < size; i++) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}