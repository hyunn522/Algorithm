import java.io.*;

public class Main {

    static final int SIZE = 3;
    static int answer;
    static char[][] map = new char[SIZE][SIZE];

    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());

        while (p-- > 0) {
            for (int i = 0; i < SIZE; i++) {
                String input = br.readLine();
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = input.charAt(j);
                }
            }

            answer = Integer.MAX_VALUE;
            dfs(0, 0);
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int idx, int cnt) {
        if (idx == SIZE * SIZE) {
            if (isAllWhite()) {
                answer = Math.min(answer, cnt);
            }
            return;
        }

        int x = idx / SIZE;
        int y = idx % SIZE;

        // case 1) 현재 칸을 누르지 않는 경우
        dfs(idx + 1, cnt);

        // case 2) 현재 칸을 누르는 경우
        click(x, y);
        dfs(idx + 1, cnt + 1);
        click(x, y); // 원복
    }

    private static boolean isAllWhite() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == '*') return false;
            }
        }
        return true;
    }

    private static void click(int x, int y) {
        for (int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;

            map[nx][ny] = map[nx][ny] == '.' ? '*' : '.';
        }
    }
}