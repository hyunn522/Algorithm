import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 정사각형의 한 변의 길이
        int n = Integer.parseInt(br.readLine());

        int[] heartPosition = new int[2];

        boolean isHeartFound = false;
        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (input[j] == '*') {
                    if (!isHeartFound) {
                        // 머리를 찾는 경우 -> 심장은 바로 아래에 위치
                        heartPosition[0] = i + 2;
                        heartPosition[1] = j + 1;
                        isHeartFound = true;
                        continue;
                    } else if (i == heartPosition[0] - 1) {
                        if (j < heartPosition[1] - 1) // 왼쪽 팔을 찾는 경우
                            leftArm++;
                        else if (j > heartPosition[1] - 1) // 오른쪽 팔을 찾는 경우
                            rightArm++;
                    } else if (i > heartPosition[0] - 1) {
                        // 허리 및 다리를 찾는 경우
                        if (j == heartPosition[1] - 1) waist++;
                        else if (j < heartPosition[1] - 1) leftLeg++;
                        else rightLeg++;
                    }
                }
            }
        }

        sb.append(heartPosition[0] + " " + heartPosition[1] + "\n");
        sb.append(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
        System.out.println(sb);
    }
}
