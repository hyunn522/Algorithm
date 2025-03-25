class Solution {
    public int solution(int[][] sizes) {
        // 짧은 길이가 idx 0에 오도록 정렬
        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];
            if (width > height) {
                size[0] = height;
                size[1] = width;
            }
        }
        
        int maxWidth = 0;
        int maxHeight = 0;
        for (int[] size : sizes) {
            if (size[0] > maxWidth) maxWidth = size[0];
            if (size[1] > maxHeight) maxHeight = size[1];
        }
        
        return maxWidth * maxHeight;
    }
}