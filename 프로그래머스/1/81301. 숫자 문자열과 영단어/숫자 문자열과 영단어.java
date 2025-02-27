class Solution {
    public int solution(String s) {
        String temp = "";
        String result = "";
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                result += String.valueOf(c);
                if (!temp.isEmpty()) {
                    result += wordToNum(temp);
                    temp = "";
                }
            }
            else {
                temp += String.valueOf(c);
                if (isWord(temp)) {
                    result += wordToNum(temp);
                    temp = "";
                }
            }
        }
        
        int answer = 0;
        int idx = result.length() - 1;
        for (char c : result.toCharArray()) {
            answer += Math.pow(10, idx) * (c - '0');
            idx--;
        }
        return answer;
    }
    
    private boolean isWord(String w) {
        if (w.equals("zero") || w.equals("one") || w.equals("two") || w.equals("three") || w.equals("four") || w.equals("five") || w.equals("six") || w.equals("seven") || w.equals("eight") || w.equals("nine")) return true;
        return false;
    }
    
    private String wordToNum(String w) {
        if (w.equals("zero")) return "0";
        else if (w.equals("one")) return "1";
        else if (w.equals("two")) return "2";
        else if (w.equals("three")) return "3";
        else if (w.equals("four")) return "4";
        else if (w.equals("five")) return "5";
        else if (w.equals("six")) return "6";
        else if (w.equals("seven")) return "7";
        else if (w.equals("eight")) return "8";
        else return "9";
    }
}