import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>(); // {userId, userName} 저장
        
        for (int i = 0; i < record.length; i++) {
            String[] tokens = record[i].split(" ");
            if (!tokens[0].equals("Leave")) {
                map.put(tokens[1], tokens[2]);
            }
        }
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] tokens = record[i].split(" ");
            switch(tokens[0]) {
                case "Enter": 
                    list.add(map.get(tokens[1]) + "님이 들어왔습니다.");
                    break;
                case "Leave": 
                    list.add(map.get(tokens[1]) + "님이 나갔습니다.");
                    break;
            }
        }
        
        String[] answer = list.stream().toArray(String[]::new);
        return answer;
    }
}