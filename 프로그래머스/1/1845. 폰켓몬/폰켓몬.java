import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 1. nums 배열을 오름차순으로 정렬
        Arrays.sort(nums);
        
        // 2. 중복을 제거하기 위해 Set 사용
        Set<Integer> uniqueNums = new HashSet<>();
        
        for (int num : nums) {
            uniqueNums.add(num);
        }
        
        // 3. 중복 제거된 개수와 nums 배열 크기의 절반을 비교
        int uniqueCount = uniqueNums.size();
        int maxSelection = nums.length / 2;
        
        // 4. 중복 없는 경우와 중복 있는 경우 처리
        return Math.min(uniqueCount, maxSelection);
    }
}
