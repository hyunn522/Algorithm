import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new List[n];
        int root = -1;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input != -1) {
                graph[input].add(i);
            } else {
                root = i;
            }
        }

        int m = Integer.parseInt(br.readLine());

        // root 노드를 지울 경우
        if (m == root) {
            System.out.println(0);
            return;
        }

        // 노드 삭제
        graph[m] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> removes = new ArrayList<>();
            for (int child : graph[i]) {
                if (child == m) {
                    removes.add(child);
                }
            }

            for (int remove : removes) {
                graph[i].remove(Integer.valueOf(remove));
            }
        }

        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int validChild = 0;

            for (int next : graph[cur]) {
                if (next != m) {
                    queue.offer(next);
                    validChild++;
                }
            }

            if (validChild == 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
