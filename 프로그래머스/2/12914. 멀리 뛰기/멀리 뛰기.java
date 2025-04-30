class Solution {
    public long solution(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else {
            int[] arr = new int[n];
            arr[0] = 1;
            arr[1] = 2;
            for (int i = 2; i < n; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
            }
            return arr[n - 1];
        }
    }
}