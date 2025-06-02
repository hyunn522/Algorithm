import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] bridge = new int[n];
        boolean[] visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine()) - 1;

        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result++;

            for (int next : new int[]{cur + bridge[cur], cur - bridge[cur]}) {
                if (next < 0 || next >= n) continue;

                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

        System.out.println(result);
    }
}