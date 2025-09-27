import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시점 기준으로 정렬
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        
        // 소요 시간 기준으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
        
        int idx = 0; // 현재 실행할 작업의 인덱스
        int time = 0; // 현재 시간
        int done = 0; // 완료된 작업 수
        int totalTime = 0; // 반환 시간의 총합
        
        while (done < jobs.length) {
            // 현재 시간까지 들어온 작업들 pq에 넣기
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }
            
            if (!pq.isEmpty()) {
                // 작업 실행
                int[] cur = pq.poll();
                int requestTime = cur[0];
                int duration = cur[1];
                
                time += duration;
                totalTime += time - requestTime;
                done++;
            } else {
                // 다음 작업의 실행 시간으로 점프
                time = Math.max(time, jobs[idx][0]);
            }
        }
        
        return (int)(totalTime / jobs.length);
    }
}