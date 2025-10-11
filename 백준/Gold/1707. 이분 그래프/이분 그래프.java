import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int v, e;
    static List<Integer>[] graph;
    static int[] flag; // 미방문 = 0, 그룹A = 1, 그룹B = -1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            graph = new List[v];
            flag = new int[v];
            for (int i = 0; i < v; i++) {
                graph[i] = new ArrayList();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                graph[a].add(b);
                graph[b].add(a);
            }

            boolean isBipartite = true;
            for (int i = 0; i < v && isBipartite; i++) {
                if (flag[i] == 0) {
                    isBipartite = bfs(i);
                }
            }

            sb.append(isBipartite ? "YES\n" : "NO\n");
        }

        System.out.println(sb);
    }

    private static boolean bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        flag[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (flag[next] == 0) {
                    flag[next] = -flag[cur];
                    queue.offer(next);
                } else if (flag[next] == flag[cur]) {
                    return false;
                }
            }
        }

        return true;
    }
}
