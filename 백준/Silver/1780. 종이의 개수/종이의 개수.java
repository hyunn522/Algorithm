import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] paper;
    static int num1, num2, num3;

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

        recursion(0, 0, n);

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }

    private static void recursion(int startX, int startY, int size) {
        int prevNum = paper[startY][startX];
        boolean isPrevSame = true;

        for (int i = startY; i < startY + size; i++) {
            for (int j = startX; j < startX + size; j++) {
                if (paper[i][j] != prevNum) {
                    isPrevSame = false;
                    break;
                }
            }
            if (!isPrevSame) break;
        }

        if (isPrevSame) {
            if (prevNum == -1) num1++;
            else if (prevNum == 0) num2++;
            else if (prevNum == 1) num3++;
            return;
        }

        int newSize = size / 3; // 잘린 종이의 한 변의 길이
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                recursion(startX + j * newSize, startY + i * newSize, newSize);
            }
        }
    }
}
