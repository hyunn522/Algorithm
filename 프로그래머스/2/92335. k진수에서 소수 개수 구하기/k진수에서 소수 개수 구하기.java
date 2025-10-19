class Solution {
    public int solution(int n, int k) {
        // n을 k진수로 바꾸기
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String convertedSt = sb.reverse().toString();
        
        // 0을 기준으로 나누기
        String[] parts = convertedSt.split("0+");
        int answer = 0;
        
        for (String part : parts) {
            if (part.isEmpty()) continue;
            long partNum = Long.parseLong(part);
            if (isPrime(partNum)) answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime(long num) {
        if (num == 1) return false;
        if (num % 2 == 0) return num == 2; // 짝수라면 2인 경우에만 소수 O
        for (int i = 3; i <= num / i; i += 2) { // i * i <= num이면서 i가 홀수인 경우에만 확인
            if (num % i == 0) return false;
        }
        return true;
    }
}