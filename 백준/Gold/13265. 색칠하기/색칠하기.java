import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] picture;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            picture = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                picture[i] = new ArrayList<>();
            }

            int start = -1;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                picture[x].add(y);
                picture[y].add(x);
                start = x;
            }

            sb.append(bfs(start) ? "possible" : "impossible").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean bfs(int start) {
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(new int[]{start, 0}); // 동그라미 번호, 색 번호
        visited[start] = true;
        colors[start] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curCircle = cur[0];
            int curColor = cur[1];
            colors[curCircle] = curColor;

            for (int next : picture[curCircle]) {
                if (colors[next] == curColor) return false;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, curColor == 0 ? 1 : 0}); // curColor와 달라야 함
                }
            }
        }

        return true;
    }
}