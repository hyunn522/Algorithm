import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        ArrayList<Integer> answerList = new ArrayList<>();
        
        // 장르에 따른 전체 노래 분류
        Map<String, List<Song>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String genre = genres[i];
            int playCnt = plays[i];
            map.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }
        
        // 장르별 재생 시간의 총합 구해서 정렬
        List<String> genreRank = new ArrayList<>(map.keySet());
        Collections.sort(genreRank, (r1, r2) ->
                         map.get(r2).stream().mapToInt(s -> s.cnt).sum()
                         - map.get(r1).stream().mapToInt(s -> s.cnt).sum());
        
        // 각 장르 내에서 내림차순 정렬해서 2개 고름
        // 재생 횟수가 같은 노래들끼리는 고유 번호 기준 오름차순 정렬
        for (String g : genreRank) {
            List<Song> songs = map.get(g);
            Collections.sort(songs, (s1, s2) -> s1.cnt == s2.cnt ? s1.idx - s2.idx : s2.cnt - s1.cnt);

            int songSize = songs.size();
            for (int i = 0; i < 2; i++) {
                if (songSize > i) {
                    answerList.add(songs.get(i).idx);
                }
            }
        }
        
        int answerSize = answerList.size();
        int[] answer = new int[answerSize];
        for (int i = 0 ; i < answerSize; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}

class Song {
    int idx;
    int cnt;
    
    Song(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
}