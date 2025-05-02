import java.util.*;

class Solution {
    
    static String[] arr = {"A", "E", "I", "O", "U"};
    static List<String> dictionary = new ArrayList<>();
    
    public int solution(String word) {
        dfs("", 0);
        return dictionary.indexOf(word);
    }
    
    private void dfs(String cur, int depth) {
        dictionary.add(cur);
        if (depth == 5) return;
        
        for (String s : arr) {
            dfs(cur + s, depth + 1);
        }
    }
}