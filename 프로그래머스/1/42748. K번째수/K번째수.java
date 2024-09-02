import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            // 제시된 인덱스를 기반으로 새로운 배열 생성
            int start = commands[i][0] - 1;  // 시작 인덱스 (0-based)
            int end = commands[i][1];        // 끝 인덱스 (exclusive)
            int k = commands[i][2] - 1;      // k번째 인덱스 (0-based)
            
            // 부분 배열 추출 및 정렬
            int[] slicedArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(slicedArray);
            
            // k번째 값을 정답에 저장
            answer[i] = slicedArray[k];
        }
        
        return answer;
    }
}
