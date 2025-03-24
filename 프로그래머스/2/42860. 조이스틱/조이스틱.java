class Solution {
    public int solution(String name) {
        int idx;
        int move = name.length() - 1;
        int answer = 0;
        
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(Math.abs(name.charAt(i) - 'A'), Math.abs('Z' - name.charAt(i) + 1));
            
            // 연속된 A의 마지막 인덱스 구하기
            idx = i + 1;
            while (idx < name.length() && name.charAt(idx) == 'A') {
                idx++;
            }
            
            move = Math.min(move, i * 2 + name.length() - idx);
            move = Math.min(move, (name.length() - idx) * 2 + i);
        }
        return answer + move;
    }
}