import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int r, c, n;
    static char[][] map;
    static int[][] times;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        times = new int[r][c];

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'O') times[i][j] = 0; // 설치 시점 기록
                else times[i][j] = -1;
            }
        }

        int time = 1;
        while (time <= n) {
            if (time % 2 == 0) {
                // 1초 동안 폭탄이 없는 곳에 모두 설치
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (map[i][j] == '.') { // 폭탄이 없는 곳
                            map[i][j] = 'O';
                            times[i][j] = time;
                        }
                    }
                }
            } else if (time >= 3) {
                // 폭발
                List<int[]> points = new ArrayList<>();
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (map[i][j] == 'O' && times[i][j] + 3 == time) {
                            points.add(new int[]{i, j});
                        }
                    }
                }

                for (int[] point : points) {
                    int x = point[0];
                    int y = point[1];
                    map[x][y] = '.';
                    times[x][y] = -1;

                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                        if (map[nx][ny] == 'O' && times[nx][ny] + 3 != time) { // 같은 시간에 폭발 예정인 폭탄은 자기 차례에 터지도록 함
                            map[nx][ny] = '.';
                            times[nx][ny] = -1;
                        }
                    }
                }
            }

            time++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
