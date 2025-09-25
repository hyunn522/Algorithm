import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            fileList.add(new File(i, file));
        }
        
        Collections.sort(fileList, (f1, f2) -> {
            // 1. head 비교
            int cmp = f1.head.toUpperCase().compareTo(f2.head.toUpperCase());
            if (cmp != 0) return cmp;

            // 2. number 비교
            cmp = Integer.compare(f1.number, f2.number);
            if (cmp != 0) return cmp;

            // 3. idx 비교
            return Integer.compare(f1.idx, f2.idx);
        });
            
        int cnt = fileList.size();
        String[] answer = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            answer[i] = fileList.get(i).original;
        }
        return answer;
    }
    
    static class File {
        int idx;
        String original;
        String head;
        int number;
        String tail;
        
        File(int idx, String original) {
            this.idx = idx;
            this.original = original;
            
            String head = "", number = "", tail = "";
            char[] fileChars = original.toCharArray();
            boolean isNumber = false;
            int numberCnt = 0;
            
            for (int j = 0; j < original.length(); j++) {
                char c = fileChars[j];
                if (c >= '0' && c <= '9') {
                    if (numberCnt == 5) {
                        tail += String.valueOf(c);
                    } else {
                        isNumber = true;
                        number += String.valueOf(c);
                        numberCnt++;
                    }
                } else {
                    if (!isNumber) {
                        head += String.valueOf(c); 
                    } else {
                        tail += String.valueOf(c);
                    }
                }
            }
            
            this.head = head;
            this.number = Integer.parseInt(number);
            this.tail = tail;
        }
    }
}