import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static String[][] map;
    static List<Point> teachers;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        teachers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("T")) teachers.add(new Point(i, j));
            }
        }

        System.out.println(dfs(0) ? "YES" : "NO");
    }

    private static boolean dfs(int depth) {
        if (depth == 3) {
            for (Point teacher : teachers) {
                for (int i = 0; i < 4; i++) {
                    int nx = teacher.x, ny = teacher.y;
                    while (true) {
                        nx += dx[i];
                        ny += dy[i];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;

                        // case 1) 현재 방향에서 피하기 불가능 -> 현재 경우 불가능
                        if (map[nx][ny].equals("S")) return false;

                        // case 2) 현재 방향에서 피하기 가능 -> 다음 방향
                        if (map[nx][ny].equals("O")) break;
                    }
                }
            }
            return true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("X")) {
                    map[i][j] = "O";
                    if(dfs(depth + 1)) return true;
                    map[i][j] = "X";
                }
            }
        }

        return false;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
