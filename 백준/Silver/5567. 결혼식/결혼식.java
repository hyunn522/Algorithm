import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static boolean[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = true;
            arr[b][a] = true;
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int result = 0;
        Queue<Relation> queue = new LinkedList<>();
        queue.offer(new Relation(0, 0));

        while (!queue.isEmpty()) {
            Relation curRelation = queue.poll();
            if (curRelation.cnt == 1 || curRelation.cnt == 2) result++;

            for (int i = 1; i < n; i++) {
                if (arr[curRelation.num][i] && !visited[i]) {
                    queue.offer(new Relation(i, curRelation.cnt + 1));
                    visited[i] = true;
                }
            }
        }

        return result;
    }

    static class Relation {
        int num, cnt;

        Relation (int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
