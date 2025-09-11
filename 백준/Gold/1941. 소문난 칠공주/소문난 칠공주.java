import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static final int SIZE = 5;

    static char[][] seats = new char[SIZE][SIZE];
    static int[] choosen = new int[7]; // 조합 만들 때 사용
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < SIZE; i++) {
            String input = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                seats[i][j] = input.charAt(j);
            }
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int idx, int chooseCnt, int sCnt) {
        // 남은 칸이 모두 'S'여도 조건 충족 X
        if (sCnt + (7 - chooseCnt) < 4) {
            return;
        }

        // 7명 조합 완성
        if (chooseCnt == 7) {
            if (isConnected()) { // 연결되어있는지 확인
                answer++;
            }
            return;
        }

        // 더 이상 확인할 칸이 없는 경우
        if (idx == 25) {
            return;
        }

        // 현재 idx를 선택하는 경우
        choosen[chooseCnt] = idx;
        int r = idx / 5;
        int c = idx % 5;
        dfs(idx + 1, chooseCnt + 1, seats[r][c] == 'S' ? sCnt + 1 : sCnt);

        // 현재 idx를 선택하지 않는 경우
        dfs(idx + 1, chooseCnt, sCnt);
    }

    // 고른 7칸이 상하좌우로 모두 연결되어있는지 확인
    static boolean isConnected() {
        boolean[] isContained = new boolean[25];
        for (int v : choosen) {
            isContained[v] = true;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[25];
        queue.offer(choosen[0]);
        visited[choosen[0]] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int x = cur / 5;
            int y = cur % 5;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) {
                    continue;
                }

                int next = nx * 5 + ny;
                if (!isContained[next] || visited[next]) {
                    continue;
                }

                queue.offer(next);
                visited[next] = true;
                cnt++;
            }
        }
        
        return cnt == 7;
    }
}
