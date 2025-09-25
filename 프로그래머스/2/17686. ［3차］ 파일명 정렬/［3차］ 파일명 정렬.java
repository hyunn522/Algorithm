import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            fileList.add(new File(i, files[i]));
        }
        
        Collections.sort(fileList, (f1, f2) -> {
            // 1. head 비교
            int cmp = f1.head.compareTo(f2.head);
            if (cmp != 0) return cmp;

            // 2. number 비교
            cmp = Integer.compare(f1.number, f2.number);
            if (cmp != 0) return cmp;

            // 3. idx 비교
            return Integer.compare(f1.idx, f2.idx);
        });
            
        String[] answer = new String[fileList.size()];
        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).original;
        }
        return answer;
    }
    
    static class File {
        int idx;
        String original;
        String head;
        int number;
        
        File(int idx, String original) {
            this.idx = idx;
            this.original = original;
            
            int i = 0;
            int length = original.length();
            
            // HEAD
            while (i < length && (original.charAt(i) < '0' || original.charAt(i) > '9')) {
                i++;
            }
            this.head = original.substring(0, i).toUpperCase();
                
            // NUMBER
            int j = i;
            int cnt = 0;
            while (j < length && (original.charAt(j) >= '0' && original.charAt(j) <= '9') && cnt < 5) {
                j++;
                cnt++;
            }
            this.number = Integer.parseInt(original.substring(i, j));
        }
    }
}