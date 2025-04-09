import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int width = triangle[height - 1].length;
        int[][] sum = new int[height][width];
        
        // sum 초기화
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                sum[i][j] = triangle[i][j];
            }
        }
        
        // 삼각형의 각 점에 대해 누적 합 계산
        for (int i = 1; i < height; i++) {
            int currentWidth = triangle[i].length;
            for (int j = 0; j < currentWidth; j++) {
                // 바로 위의 왼쪽 칸, 바로 위의 오른쪽 칸의 경우 비교
                int max = 0;
                if (j > 0) max = Math.max(max, sum[i - 1][j - 1]);
                if (j < width - 1) max = Math.max(max, sum[i - 1][j]);
                sum[i][j] = max + triangle[i][j];
            }
        }
        
        int[] maxArr = sum[height - 1];
        Arrays.sort(maxArr);
        return maxArr[height - 1];
    }
}