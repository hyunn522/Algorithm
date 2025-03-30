class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown / 2 + 2; // width + height
        int product = yellow + 2 * sum - 4; // width * height
        
        int width = 0, height = 0;
        for (int i = 1; i < sum; i++) {
            int a = sum - i;
            int b = i;
            if (a * b == product) {
                width = a;
                height = b;
                break;
            }
        }
        
        int[] answer = {width, height};
        return answer;
    }
}