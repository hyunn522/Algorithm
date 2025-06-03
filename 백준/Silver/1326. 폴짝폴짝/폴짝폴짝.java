import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] bridge = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        int answer = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>(); // {현재 위치, 점프 횟수}
        queue.offer(new int[]{a, 0});
        boolean[] visited = new boolean[n];
        visited[a] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curIdx = cur[0];
            int curCnt = cur[1];

            if (curIdx == b) {
                answer = Math.min(answer, curCnt);
                continue;
            }

            for (int dx : new int[]{bridge[curIdx], -bridge[curIdx]}) {
                for (int i = 1; i < n; i++) {
                    int nextIdx = curIdx + dx * i;
                    if (nextIdx < 0 || nextIdx >= n) break;

                    if (!visited[nextIdx]) {
                        queue.offer(new int[]{nextIdx, curCnt + 1});
                        visited[nextIdx] = true;
                    }
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}