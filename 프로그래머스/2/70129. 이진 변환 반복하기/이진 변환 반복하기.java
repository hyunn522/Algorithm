class Solution {
    public int[] solution(String s) {
        int changeCnt = 0, removedCnt = 0;
        
        while (!s.equals("1")) {
            String removedStr = s.replace("0", "");
            removedCnt += s.length() - removedStr.length();
            
            int c = removedStr.length();
            String newStr = "";
            
            while (c > 0) {
                newStr = String.valueOf(c % 2) + newStr;
                c /= 2;
            }
            
            s = newStr;
            changeCnt++;
        }
        
        return new int[]{changeCnt, removedCnt};
    }
}