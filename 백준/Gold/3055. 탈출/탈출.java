import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static char[][] map;
    static Queue<Point> hedgehog = new LinkedList<>();
    static Queue<Point> water = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];

        int startX = -1, startY = -1;
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == '*') {
                    water.offer(new Point(i, j));
                }
                else if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        hedgehog.offer(new Point(startX, startY));
        visited[startX][startY] = true;
        escape();
    }

    private static void escape() {
        while (!hedgehog.isEmpty()) {
            answer++;
            flood();

            int size = hedgehog.size();
            for (int i = 0; i < size; i++) {
                Point currentHedgehog = hedgehog.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = currentHedgehog.x + dx[d];
                    int ny = currentHedgehog.y + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        if (map[nx][ny] == 'D') {
                            System.out.println(answer);
                            return;
                        } else if (map[nx][ny] == '.' && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            hedgehog.offer(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }

    private static void flood() {
        int size = water.size();
        for (int t = 0; t < size; t++) {
            Point point = water.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
                        map[nx][ny] = '*';
                        water.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
