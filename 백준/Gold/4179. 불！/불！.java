import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static char[][] maze;
    static Queue<Point> human = new LinkedList<>();
    static Queue<Point> fire = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        maze = new char[r][c];
        visited = new boolean[r][c];

        int startX = -1, startY = -1;
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = input.charAt(j);
                if (maze[i][j] == 'F') {
                    fire.offer(new Point(i, j));
                }
                else if (maze[i][j] == 'J') {
                    startX = i;
                    startY = j;
                }
            }
        }

        human.offer(new Point(startX, startY));
        visited[startX][startY] = true;
        escape();
    }

    private static void escape() {
        while (!human.isEmpty()) {
            answer++;
            burn();

            int size = human.size();
            for (int i = 0; i < size; i++) {
                Point current = human.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = current.x + dx[d];
                    int ny = current.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        System.out.println(answer);
                        return;
                    }

                    if (maze[nx][ny] == '.' && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        human.offer(new Point(nx, ny));
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static void burn() {
        int size = fire.size();
        for (int t = 0; t < size; t++) {
            Point point = fire.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (maze[nx][ny] == '.' || maze[nx][ny] == 'J') {
                        maze[nx][ny] = 'F';
                        fire.offer(new Point(nx, ny));
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
