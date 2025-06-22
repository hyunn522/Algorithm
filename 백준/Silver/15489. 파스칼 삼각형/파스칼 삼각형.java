import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        long[][] map = new long[30][30];
        map[0][0] = 1;
        map[1][0] = 1;
        map[1][1] = 1;

        for (int i = 2; i < 30; i++) {
            if (i >= r + w - 1) break;

            map[i][0] = 1;
            for (int j = 1; j < 29; j++) {
                map[i][j] = map[i - 1][j] + map[i - 1][j - 1];
                if (map[i - 1][j] == 0) {
                    map[i][j] = 1;
                    break;
                }
            }
        }

        int cnt = 1;
        long answer = 0;
        for (int i = r - 1; i < r + w - 1; i++) {
            for (int j = 0; j < cnt; j++) {
                answer += map[i][c + j - 1];
            }
            cnt++;
        }

        System.out.println(answer);
    }
}