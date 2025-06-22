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

        for (int i = 2; i < r + w - 1; i++) {
            map[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
            }
        }

        long answer = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j <= i; j++) {
                answer += map[r + i - 1][c + j - 1];
            }
        }

        System.out.println(answer);
    }
}