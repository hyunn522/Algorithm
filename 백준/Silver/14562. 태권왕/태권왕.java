import java.io.*;
import java.util.*;

public class Main {

    static int s, t;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < c; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            sb.append(bfs()).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs() {
        int result = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{s, t, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curS = cur[0];
            int curT = cur[1];
            int curCnt = cur[2];

            if (curS == curT) {
                result = curCnt;
                break;
            }

            if (curS > curT) continue;

            queue.offer(new int[]{curS * 2, curT + 3, curCnt + 1});
            queue.offer(new int[]{curS + 1, curT, curCnt + 1});
        }

        return result;
    }
}