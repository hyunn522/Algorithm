import java.io.*;
import java.util.*;

public class Main {

    static int n, m, s, e;
    static List<Integer>[] map;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken()) - 1;
        e = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x].add(y);
            map[y].add(x);
        }

        bfs();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{s, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (curNode == e) {
                System.out.println(curDist);
                return;
            }

            List<Integer> nexts = new ArrayList<>();
            nexts.add(curNode + 1);
            nexts.add(curNode - 1);
            for (int i : map[curNode]) {
                if (i != curNode + 1 && i != curNode - 1) nexts.add(i);
            }

            for (int nextNode : nexts) {
                if (nextNode < 0 || nextNode >= n) continue;

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(new int[]{nextNode, curDist + 1});
                }
            }
        }
    }
}