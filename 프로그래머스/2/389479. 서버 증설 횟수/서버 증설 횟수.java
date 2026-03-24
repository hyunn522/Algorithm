class Solution {
    public int solution(int[] players, int m, int k) {
        int[] newServers = new int[24]; // 각 시간대에 증설한 서버의 수        
        for (int t = 0; t < 24; t++) {    
            int player = players[t];
            if (player < m) continue;
            
            // (현재 시간대 - k + 1) ~ (현재 시간대 - 1)의 newServers를 보고 현재 시간대에서 게임을 이용할 수 있는 사람 수 확인
            int possiblePlayer = 0;
            for (int i = 1; i < k; i++) {
                if (t - i < 0) break;
                possiblePlayer += newServers[t - i];
            }
            possiblePlayer *= m;
            
            // 해당 시간대의 이용자 수가 가용 인원수보다 적다면 continue
            if (player <= possiblePlayer) continue;
            
            // 많다면 증설
            newServers[t] = (player - possiblePlayer) / m;
        }
        
        int answer = 0;
        for (int i : newServers) {
            answer += i;
        }
        return answer;
    }
}