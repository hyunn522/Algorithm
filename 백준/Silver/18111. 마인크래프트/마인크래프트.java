import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m, b, answer = Integer.MAX_VALUE, height;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ;j < m; j++) {
                int h = Integer.parseInt(st.nextToken());
                min = Math.min(min, h);
                max = Math.max(max, h);
                map[i][j] = h;
            }
        }

        for (int i = max; i >= min; i--) {
            checkRemove(i);
        }

        System.out.println(answer + " " + height);
    }

    private static void checkRemove(int h) {
        int time = 0;
        int inventory = b;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (time > answer) { // 이미 구했던 최소 시간보다 커질 경우 종료
                    return;
                }

                if (map[i][j] < h) { // 블록 쌓기
                    time += h - map[i][j];
                    inventory -= h - map[i][j];
                } else if (map[i][j] > h) { // 블록 깎기
                    time += 2 * (map[i][j] - h);
                    inventory += map[i][j] - h;
                }
            }
        }

        if (inventory >= 0 && time < answer) { // 가능한 경우
            answer = time;
            height = h;
        }
    }
}
