import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[][] times = new int[n][2];
        
        // 1) 시간을 분 단위로 변환 -> [startMin, endMin + 10]으로 저장
        for (int i = 0; i < n; i++) {
            String[] books = book_time[i];
            for (int j = 0; j < 2; j++) {
                String s = books[j];               
                int h = Integer.parseInt(s.substring(0, 2));
                int m = Integer.parseInt(s.substring(3, 5));
                if (j == 1) m += 10;               
                
                times[i][j] = h * 60 + m;
            }
        }
        
        // 2) 시작 시간 기준으로 정렬
        Arrays.sort(times, (o1, o2) -> o1[0] - o2[0]);
        
        // 3) 현재 사용 중인 방들에 대해 종료 시간 오름차순으로 저장
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int curStart = times[i][0];
            int curEnd = times[i][1];
            
            // 가장 먼저 끝나는 방이 현재 보고 있는 방보다 먼저 끝나는 경우 -> 재사용
            while (!pq.isEmpty() && pq.peek() <= curStart) {
                pq.poll();
            }
            
            pq.offer(curEnd);
            
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
}