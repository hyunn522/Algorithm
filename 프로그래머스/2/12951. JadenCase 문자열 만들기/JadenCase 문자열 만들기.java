class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        boolean isWordStart = true;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
        
            if (c == ' ') {
                sb.append(c);
                isWordStart = true;
            } else {
                if (isWordStart) {
                    sb.append(Character.isLetter(c) ? Character.toUpperCase(c) : c);
                    isWordStart = false;
                } else {
                    sb.append(Character.isLetter(c) ? Character.toLowerCase(c): c);
                }
            }
        }
        
        return sb.toString();
    }
}