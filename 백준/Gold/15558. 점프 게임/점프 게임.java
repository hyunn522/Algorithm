import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[][] map; // 왼쪽, 오른쪽 줄의 칸
    static boolean[][] visited; // 왼쪽, 오른쪽 줄에 대한 방문 여부

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[2][n];
        visited = new boolean[2][n];

        for (int t = 0; t < 2; t++) {
            String input = br.readLine();
            for (int i = 0; i < n; i++) {
                map[t][i] = input.charAt(i) - '0';
            }
        }

        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(0, 0, 0)); // 왼쪽 첫 번째 칸에서 시작
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Info cur = queue.poll();
            int curIdx = cur.curIdx;
            int curLine = cur.curLine;
            int removeIdx = cur.removeIdx;

            for (int[] nextInfo : new int[][]{new int[]{curIdx + 1, curLine}, new int[]{curIdx - 1, curLine}, new int[]{curIdx + k, (curLine + 1) % 2}}) {
                int nextIdx = nextInfo[0];
                int nextLine = nextInfo[1];

                if (nextIdx >= n) {
                    System.out.println(1);
                    return;
                }

                if (nextIdx < 0 || nextIdx <= removeIdx) continue;

                if (!visited[nextLine][nextIdx] && map[nextLine][nextIdx] == 1) {
                    visited[nextLine][nextIdx] = true;
                    queue.offer(new Info(nextIdx, nextLine, removeIdx + 1));
                }
            }
        }

        System.out.println(0);
    }

    static class Info {
        int curIdx, curLine, removeIdx;

        Info(int curIdx, int curLine, int removeIdx) {
            this.curIdx = curIdx;
            this.curLine = curLine;
            this.removeIdx = removeIdx;
        }
    }
}