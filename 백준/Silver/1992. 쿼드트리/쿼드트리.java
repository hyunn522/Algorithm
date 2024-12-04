import java.io.*;

public class Main {

    static int n;
    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        video = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                video[i][j] = input[j] - '0';
            }
        }
        br.close();

        recursion(0, 0, n);

        System.out.println(sb);
    }

    private static void recursion(int startX, int startY, int size) {
        int prevNum = video[startY][startX];
        boolean isAllSame = true;

        for (int i = startY ; i < startY + size; i++) {
            for (int j = startX; j < startX + size; j++) {
                if (video[i][j] != prevNum) {
                    isAllSame = false;
                    break;
                }
            }
            if (!isAllSame) break;
        }

        if(isAllSame) {
            sb.append(prevNum);
            return;
        }

        sb.append("(");
        int newSize = size / 2;
        for (int i = startY; i < startY + size; i += newSize) {
            for (int j = startX; j < startX + size; j += newSize) {
                recursion(j, i, newSize);
            }
        }
        sb.append(")");
    }
}
