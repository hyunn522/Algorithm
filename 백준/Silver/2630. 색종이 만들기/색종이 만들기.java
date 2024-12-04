import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] paper;
    static int whiteCnt, blueCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        recursion(0, 0, n);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    private static void recursion(int startX, int startY, int size) {
        int prevNum = paper[startY][startX];
        boolean isAllSame = true;

        for (int i = startY ; i < startY + size; i++) {
            for (int j = startX; j < startX + size; j++) {
                if (paper[i][j] != prevNum) {
                    isAllSame = false;
                    break;
                }
            }
            if (!isAllSame) break;
        }

        if(isAllSame) {
            if (prevNum == 0) whiteCnt++;
            else blueCnt++;
            return;
        }

        int newSize = size / 2;
        for (int i = startY; i < startY + size; i += newSize) {
            for (int j = startX; j < startX + size; j += newSize) {
                recursion(j, i, newSize);
            }
        }
    }
}
