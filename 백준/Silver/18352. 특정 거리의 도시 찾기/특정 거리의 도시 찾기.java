import java.io.*;
import java.util.*;

public class Main {

    static int k, x;
    static List<Integer>[] graph;
    static int[] dist;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()) - 1;
        graph = new ArrayList[n];
        dist = new int[n]; // x로부터의 각 점까지의 거리

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, -1);
        dist[x] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(b);
        }

        System.out.println(bfs());
    }

    private static StringBuilder bfs() {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (dist[cur] == k) result.add(cur + 1);
            if (dist[cur] > k) break;

            for (int next : graph[cur]) {
                if (dist[next] != -1) continue; // 이미 최단 거리로 초기화됨
                dist[next] = dist[cur] + 1;
                queue.offer(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (result.isEmpty()) {
            sb.append(-1);
        } else {
            Collections.sort(result);
            for (int i : result) {
                sb.append(i + "\n");
            }
        }

        return sb;
    }
}