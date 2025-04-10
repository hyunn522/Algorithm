class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String tree : skill_trees) {
            char[] cur = tree.toCharArray();
            String same = "";
            
            for (int i = 0; i < cur.length; i++) {
                if (skill.contains(String.valueOf(cur[i]))) same += String.valueOf(cur[i]);
            }
            
            // 시작하는 부분부터 같아야 함
            boolean isPossible = true;
            for (int i = 0; i < same.length(); i++) {
                if (same.charAt(i) != skill.charAt(i)) {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) answer++;
        }
        
        return answer;
    }
}