import java.util.*;

class Solution {
    
    private static List<String> union, inter;
    
    public int solution(String str1, String str2) {
        List<String> word1 = createSet(str1);
        List<String> word2 = createSet(str2);
        
        if (word1.isEmpty() && word2.isEmpty()) {
            return 65536;
        }
        union = new ArrayList<String>();
        inter = new ArrayList<String>();
        
        getSimilarity(word1, word2, word1.size(), word2.size());
        
        float jacarrd = (float)inter.size() / union.size();
        return (int)(jacarrd * 65536);
    }
    
    private List<String> createSet(String str) {
        List<String> set = new ArrayList<>();
        
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            
            // 소문자로 통일
            c1 = Character.toLowerCase(c1);
            c2 = Character.toLowerCase(c2);
            
            // 영문자가 아닌 경우 패스
            if (c1 < 'a' || c1 > 'z' || c2 < 'a' || c2 > 'z')
                continue;
            
            String word = Character.toString(c1) + Character.toString(c2);
            set.add(word);
        }
        
        return set;
    }
    
    private void getSimilarity(List<String> word1, List<String> word2, int smallCnt, int bigCnt) {
        for (int i = 0; i < smallCnt; i++) {
            String w = word1.get(i);
            if (word2.remove(w)) {
                inter.add(w);
            }
            union.add(w);
        }
        
        union.addAll(word2);
    }
}