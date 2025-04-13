import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] map;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[101];
        for (int i = 0; i < 101; i++) {
            map[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u] = v;
        }

        roll();

        System.out.println(answer);
    }

    static void roll() {
        int[] check = new int[101]; //  방문 순서 기록
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        check[1] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;

                if (next > 100) continue;

                if (check[map[next]] == 0) { // 이전에 방문하지 않은 경우
                    queue.offer(map[next]);
                    check[map[next]] = check[cur] + 1;
                }

                if (map[next] == 100) {
                    answer = check[100];
                    return;
                }
            }
        }
    }
}
