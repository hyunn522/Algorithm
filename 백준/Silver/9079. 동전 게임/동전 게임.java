import java.io.*;
import java.util.*;

public class Main {

    static Point[][] directions = {
            {new Point(0, 0), new Point(0, 1), new Point(0, 2)},
            {new Point(1, 0), new Point(1, 1), new Point(1, 2)},
            {new Point(2, 0), new Point(2, 1), new Point(2, 2)},
            {new Point(0, 0), new Point(1, 0), new Point(2, 0)},
            {new Point(0, 1), new Point(1, 1), new Point(2, 1)},
            {new Point(0, 2), new Point(1, 2), new Point(2, 2)},
            {new Point(0, 0), new Point(1, 1), new Point(2, 2)},
            {new Point(0, 2), new Point(1, 1), new Point(2, 0)}};

    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            boolean[][] game = new boolean[3][3];
            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    game[i][j] = st.nextToken().equals("H"); // 뒤집기 연산을 편하게 하기 위해 boolean으로 저장
                }
            }

            answer = Integer.MAX_VALUE;
            dfs(game, 0, 0);
            sb.append(answer == Integer.MAX_VALUE ? -1 : answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(boolean[][] game, int depth, int directionIndex) {
        if (isDone(game)) {
            answer = Math.min(answer, depth);
            return;
        }

        if (directionIndex >= directions.length) return;

        // 현재 direction을 적용하지 않는 경우
        dfs(game, depth, directionIndex + 1);

        // 현재 direction을 적용하는 경우
        for (Point p : directions[directionIndex]) {
            game[p.x][p.y] = !game[p.x][p.y];
        }
        dfs(game, depth + 1, directionIndex + 1);

        // 롤백
        for (Point p : directions[directionIndex]) {
            game[p.x][p.y] = !game[p.x][p.y];
        }
    }

    private static boolean isDone(boolean[][] game) {
        boolean cur = game[0][0];

        for (boolean[] arr : game) {
            for (boolean b : arr) {
                if (b != cur) return false;
            }
        }

        return true;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x ;
            this.y = y;
        }
    }
}
