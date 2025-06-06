import java.io.*;
import java.util.*;

public class Main {

    static int n, m, r;
    static List<Integer>[] graph;
    static int[][] result; // 노드 i의 깊이와 방문 순서 저장

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        graph = new ArrayList[n];
        result = new int[n][2];
        for (int i = 0; i < n ;i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0 ; i < n; i++) {
            Collections.sort(graph[i]);
        }

        bfs();

        long answer = 0;
        for (int[] r : result) {
            answer += (long)r[0] * r[1];
        }
        System.out.println(answer);
    }

    private static void bfs() {
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();

        visited[r] = true;
        queue.offer(new int[]{r, 0}); // 노드 번호, 깊이

        int order = 1;
        result[r][0] = 0; // 시작 노드의 깊이는 0
        result[r][1] = order++; // 시작 노드의 방문 순서는 1

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curNode = cur[0];
            int curDepth = cur[1];

            for (int next : graph[curNode]) {
                int nextDepth = curDepth + 1;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, nextDepth});
                    result[next][0] = nextDepth;
                    result[next][1] = order++;
                }
            }
        }
    }
}