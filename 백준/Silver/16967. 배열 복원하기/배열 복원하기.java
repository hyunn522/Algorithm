import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] arrA = new int[h][w];
        for (int i = 0; i < h + x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w + y; j++) {
                int b = Integer.parseInt(st.nextToken());
                if (i < h && j < w) {
                    if (i < x || j < y) arrA[i][j] = b;
                    else arrA[i][j] = b - arrA[i - x][j - y];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(arrA[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
