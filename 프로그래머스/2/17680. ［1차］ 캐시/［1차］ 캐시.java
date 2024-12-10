import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        Queue<String> cache = new ArrayDeque<>();
        int answer = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (cacheSize == 0) {
                answer += 5;
                continue;
            }
            
            if (cache.isEmpty()) {
                // cache가 없으므로 cache miss
                cache.offer(city);
                answer += 5;
                continue;
            }
            
            if (cache.contains(city)) {
                // cache hit
                cache.remove(city);
                cache.offer(city);
                answer += 1;
            } else {
                // cache miss
                if (cache.size() == cacheSize) {
                    // cacheSize 초과 시 cache에서 LRU city 제거 후 추가
                    cache.poll();
                }
                cache.offer(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}