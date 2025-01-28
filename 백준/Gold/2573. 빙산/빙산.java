import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] sea;
    static boolean[][] visited;
    static Queue<Point> ice = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int iceCnt;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sea = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] > 0) ice.offer(new Point(i, j, sea[i][j]));
            }
        }

        ice.offer(new Point(-1, -1, 0)); // 시간 구분 노드
        while (!ice.isEmpty()) {
            Point point = ice.poll();
            if (point.x == -1 && point.y == -1) { // 1초가 지남
                answer++;
                // ice에 저장돼있는 값들을 sea로 덮어쓰기
                for (Point p : ice) {
                    sea[p.x][p.y] = p.ice;
                }

                if (!ice.isEmpty()) { // 다음 시간에서 녹을 빙산이 있을 때 구분 노드 추가
                    ice.offer(point);
                }

                iceCnt = 0;
                visited = new boolean[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (sea[i][j] > 0 && !visited[i][j]) {
                            findIceCnt(i, j); // 몇 덩이인지 찾음
                            iceCnt++;
                        }
                    }
                }
                if (iceCnt >= 2) {
                    System.out.println(answer);
                    return;
                }
                continue;
            }

            if (point.ice > 0) melt(point);
        }
        System.out.println(0);
    }

    static void findIceCnt(int startX, int startY) {
        visited[startX][startY] = true;

        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (sea[nx][ny] > 0 && !visited[nx][ny]) {
                    findIceCnt(nx, ny);
                }
            }
        }
    }

    static void melt(Point point) {
        // 동서남북의 바닷물 개수 카운트
        int meltCnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (sea[nx][ny] == 0) meltCnt++;
            }
        }

        // 임의로 point 내부에 줄어든 ice 저장
        point.ice = point.ice >= meltCnt ? point.ice - meltCnt : 0;
        if (point.ice >= 0) ice.offer(point);
    }

    static class Point {
        int x, y, ice;

        Point(int x, int y, int ice) {
            this.x = x;
            this.y = y;
            this.ice = ice;
        }
    }
}
