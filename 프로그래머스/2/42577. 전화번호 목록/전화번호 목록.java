import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String num1 = phone_book[i];
            String num2 = phone_book[i + 1];
            if (num2.startsWith(num1)) return false;
        }
        
        return true;
    }
}