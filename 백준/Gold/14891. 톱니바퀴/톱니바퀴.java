import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int k;
    private static int[][] wheels = new int[4][8];
    private static int[] directions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = s.charAt(j) - '0';
            }
        }

        k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            directions = new int[4];
            int wheel = Integer.parseInt(st.nextToken()) - 1;
            int rotation = Integer.parseInt(st.nextToken());

            directions[wheel] = rotation;
            setDirection(wheel);
            rotateWheel();
        }

        br.close();

        int result = 0;
        if (wheels[0][0] == 1) result += 1;
        if (wheels[1][0] == 1) result += 2;
        if (wheels[2][0] == 1) result += 4;
        if (wheels[3][0] == 1) result += 8;

        System.out.println(result);
    }

    private static void setDirection(int w) {
        // 왼쪽 바퀴들의 회전 방향 설정
        for (int i = w - 1; i >= 0; i--) {
            if (wheels[i][2] != wheels[i + 1][6]) {
                directions[i] = -directions[i + 1];
            } else break;
        }
        // 오른쪽 바퀴들의 회전 방향 설정
        for (int i = w + 1; i < 4; i++) {
            if (wheels[i][6] != wheels[i - 1][2]) {
                directions[i] = -directions[i - 1];
            } else break;
        }
    }

    private static void rotateWheel() {
        for (int i = 0; i < 4; i++) {
            if (directions[i] == 1) {
                // 시계 방향 회전
                int tmp = wheels[i][7];
                for (int j = 7; j > 0; j--) {
                    wheels[i][j] = wheels[i][j - 1];
                }
                wheels[i][0] = tmp;
            }
            if (directions[i] == -1) {
                // 반시계 방향 회전
                int tmp = wheels[i][0];
                for (int j = 0; j < 7; j++) {
                    wheels[i][j] = wheels[i][j + 1];
                }
                wheels[i][7] = tmp;
            }
        }
    }

}
