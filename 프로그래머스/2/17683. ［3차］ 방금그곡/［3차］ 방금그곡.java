import java.util.*;

class Solution {
    
    public String solution(String m, String[] musicinfos) {
        List<String> mList = convertToPitches(m);
        
        String answer = "(None)";
        int answerIdx = -1;
        int answerPlayTime = Integer.MIN_VALUE;
        
        for (int i = 0; i < musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            
            String[] startTime = infos[0].split(":");
            String[] endTime = infos[1].split(":");
            String musicName = infos[2];
            String code = infos[3];
            
            // 재생 시간 계산
            int playTime = (Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0])) * 60 + Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]);
            
            List<String> codeList = convertToPitches(code);
            List<String> newCodeList = new ArrayList<>();
            int codeLen = codeList.size();
            
            if (playTime <= codeLen) {
                // 재생 시간이 코드 길이 이하 -> 코드 끊김
                newCodeList = codeList.subList(0, playTime);
            } else {
                // 재생 시간이 코드 길이 초과 -> 코드 반복
                int cnt = playTime / codeLen;
                for (int j = 0; j < cnt; j++) {
                    newCodeList.addAll(codeList);
                }
                
                newCodeList.addAll(codeList.subList(0, playTime - cnt * codeLen));
            }
            
            // newCodeList에 melody가 있으면 정답 가능한지 갱신
            String newCode = formatWithToken(newCodeList);
            String melody = formatWithToken(mList);
            if (newCode.contains(melody)) {
                if (playTime > answerPlayTime || (playTime == answerPlayTime && i < answerIdx)) {
                    answer = musicName;
                    answerIdx = i;
                    answerPlayTime = playTime;
                }
            }
        
        }
        
        return answer;
    }
    
    static List<String> convertToPitches(String m) {
        List<String> pitches = new ArrayList<>();
        for (int i = 0; i < m.length(); i++) {                 
            if (i + 1 < m.length() && m.charAt(i + 1) == '#') {
                pitches.add(m.substring(i, i + 2));
                i++;
            } else {
                pitches.add(m.substring(i, i + 1));
            }
        }
        
        return pitches;
    }
    
    static String formatWithToken(List<String> pitches) {
        StringBuilder sb = new StringBuilder();
        for (String s : pitches) sb.append(s).append(",");
        return sb.toString();
    }
}