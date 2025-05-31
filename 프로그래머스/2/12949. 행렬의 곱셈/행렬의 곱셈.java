class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        
        int[][] answer = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int result = 0;
                for (int x = 0; x < arr1[0].length; x++) {
                    result += arr1[i][x] * arr2[x][j];
                }
                answer[i][j] = result;
            }
        }
        
        
        return answer;
    }
}