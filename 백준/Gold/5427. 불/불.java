import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int w, h;
    static char[][] building;
    static Queue<Point> fire;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            building = new char[h][w];
            visited = new boolean[h][w];
            fire = new LinkedList<>();

            int startX = 0, startY = 0;
            for (int i = 0; i < h; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    building[i][j] = input[j];
                    if (building[i][j] == '*') {
                        fire.add(new Point(i, j));
                    } else if (building[i][j] == '@') {
                        startX = i;
                        startY = j;
                    }
                }
            }
            escape(startX, startY);
        }
        System.out.println(sb);
    }

    static void escape(int startX, int startY) {
        int time = -1;

        Queue<Point> human = new LinkedList<>();
        human.offer(new Point(-1, -1)); // 레벨 구분을 위한 노드
        human.offer(new Point(startX, startY));
        visited[startX][startY] = true;

        while (!human.isEmpty()) {
            Point current = human.poll();

            if (current.x == -1 && current.y == -1) { // 다음 레벨 시작
                burn(); // 불 번짐
                if (!human.isEmpty()) human.offer(current); // 레벨 구분
                time++;
                continue;
            }

            // 상근이 이동
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= h || ny >= w || nx < 0 || ny < 0) { // 탈출
                    sb.append(time + 1 + "\n");
                    return;
                }
                if (building[nx][ny] == '.' && !visited[nx][ny]) { // 이동
                    human.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        sb.append("IMPOSSIBLE\n");
    }

    static void burn() {
        int fireSize = fire.size();

        for (int i = 0; i < fireSize; i++) {
            Point current = fire.poll();

            for (int j = 0; j < 4; j++) {
                int nx = current.x + dx[j];
                int ny = current.y + dy[j];

                if (nx >= 0 && ny >= 0 && nx < h && ny < w ) {
                    if (building[nx][ny] == '.' || building[nx][ny] == '@') {
                        fire.offer(new Point(nx, ny));
                        building[nx][ny] = '*';
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
