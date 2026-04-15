import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> possibleViruses, selectedViruses;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        possibleViruses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    possibleViruses.add(new int[]{i, j});
                }
            }
        }

        // 2인 전체 칸 중 m개를 선택해서 바이러스를 놓았을 때, 각 경우 중 바이러스가 가장 빨리 퍼지는 경우 구하기
        for (int i = 0; i < possibleViruses.size(); i++) {
            selectedViruses = new ArrayList<>();
            selectedViruses.add(new int[]{possibleViruses.get(i)[0], possibleViruses.get(i)[1]});
            find(i, 1);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void find(int idx, int cnt) {
        if (cnt == m) {
            answer = Math.min(answer, bfs());
            return;
        }

        for (int i = idx + 1; i < possibleViruses.size(); i++) {
            selectedViruses.add(new int[]{possibleViruses.get(i)[0], possibleViruses.get(i)[1]});
            find(i, cnt + 1);
            selectedViruses.remove(selectedViruses.size() - 1);
        }
    }

    private static int bfs() {
        int result = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[n][n];
        for (int[] selectedVirus : selectedViruses) {
            int x = selectedVirus[0];
            int y = selectedVirus[1];
            queue.offer(new int[]{x, y, 0}); // (x, y, 시간)
            visited[x][y] = true;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curTime = cur[2];
            result = Math.max(result, curTime);

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] != 1) {
                    queue.offer(new int[]{nx, ny, curTime + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        // 전부 감염됐는지 검증
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 1) {
                    return Integer.MAX_VALUE;
                }
            }
        }

        return result;
    }
}