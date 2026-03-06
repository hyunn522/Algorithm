import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine()) - 1;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[]{v, w});
        }

        // 시작점에서 각 정점까지의 간선
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        pq.offer(new int[]{k, 0});
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curV = cur[0];
            int curW = cur[1];

            if (dist[curV] < curW) {
                continue;
            }

            // u와 연결된 간선 확인
            for (int[] edge : graph.get(curV)) {
                int nextV = edge[0];
                int nextW = edge[1];
                if (dist[curV] + nextW < dist[nextV]) {
                    dist[nextV] = dist[curV] + nextW;
                    pq.offer(new int[]{nextV, dist[nextV]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : dist) {
            sb.append(i == Integer.MAX_VALUE ? "INF" : i).append("\n");
        }
        System.out.println(sb);
    }
}
