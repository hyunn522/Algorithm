import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, cnt;
    static int[] next;
    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            next = new int[n];
            visited = new boolean[n];
            finished = new boolean[n];
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(st.nextToken()) - 1;
                next[i] = input;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            sb.append(n - cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = start;

        while (true) {
            if (!visited[cur]) {
                visited[cur] = true;
                stack.push(cur);
                cur = next[cur];
                continue;
            }

            if (!finished[cur]) {
                while (true) {
                    int x = stack.pop();
                    finished[x] = true;
                    cnt++;
                    if (x == cur) {
                        break;
                    }
                }
            }

            break;
        }

        // 사이클에 포함되지 않는 경로 처리 완료 표시
        while (!stack.isEmpty()) {
            finished[stack.pop()] = true;
        }
    }
}
