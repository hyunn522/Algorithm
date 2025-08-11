import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int timeUnit = fees[2];
        int feeUnit = fees[3];
        
        // 차량들의 입/출차 기록
        Map<Integer, int[]> recordMap = new HashMap<>(); // {주차번호, [hh, mm]}
        // 차량들의 총 주차 요금 합
        Map<Integer, Integer> resultMap = new HashMap<>(); // {주차번호, 총 주차 요금}
        for (String record : records) {
            // 공백 기준으로 파싱
            String[] s = record.split(" ");
            String[] dates = s[0].split(":");
            
            int endHour = Integer.parseInt(dates[0]);
            int endMin = Integer.parseInt(dates[1]);
            int curNum = Integer.parseInt(s[1]);
            boolean isEnter = s[2].equals("IN");
            
            if (isEnter) { // 입차인 경우
                recordMap.put(curNum, new int[]{endHour, endMin});
            } else { // 출차인 경우
                // 저장된 시간과의 차이 계산
                int[] startTime = recordMap.get(curNum);
                int startHour = startTime[0];
                int startMin = startTime[1];
                
                int diff = (endHour - startHour) * 60 + (endMin - startMin);
                recordMap.remove(curNum);
                resultMap.put(curNum, resultMap.getOrDefault(curNum, 0) + diff);
            }
        }
        
        // recordMap에 아직 남아있으면 23:59까지의 시간 계산
        for (Map.Entry<Integer, int[]> elem : recordMap.entrySet()) {
            int curNum = elem.getKey();
            int[] startTime = recordMap.get(curNum);
            int startHour = startTime[0];
            int startMin = startTime[1];
            
            int diff = (23 - startHour) * 60 + (59 - startMin);
            resultMap.put(curNum, resultMap.getOrDefault(curNum, 0) + diff);
        }
        
        // resultMap의 주차 요금을 기준에 따라 계산
        for (int curNum : resultMap.keySet()) {
            int totalTime = resultMap.get(curNum);
            int totalFee = basicFee;
            if (totalTime > basicTime) {
                totalFee += ((totalTime - basicTime + timeUnit - 1) / timeUnit) * feeUnit;
            }
            resultMap.put(curNum, totalFee);
        }
        
        // resultMap의 결과들을 주차 번호에 따라 정렬
        int[] answer = new int[resultMap.size()];
        Map<Integer, Integer> sortedByNum = new TreeMap<>(resultMap);
        
        int idx = 0;
        for (int key : sortedByNum.keySet()) {
            answer[idx] = sortedByNum.get(key);
            idx++;
        }
        
        return answer;
    }
}