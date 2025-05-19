import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt(); // 테스트 케이스 번호
            List<Score> scores = new ArrayList<>();

            for (int i = 0; i < 1000; i++) {
                int n = sc.nextInt();

                boolean isExist = false;
                for (Score score : scores) {
                    if (score.num == n) {
                        score.cnt++;
                        isExist = true;
                    }
                }
                if (!isExist) scores.add(new Score(n, 1));
            }

            scores.sort((s1, s2) -> s2.cnt - s1.cnt);

            int answer = scores.get(0).num;
            for (Score score : scores) {
                if (score.cnt == scores.get(0).cnt) {
                    answer = Math.max(answer, score.num);
                } else break;
            }

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }

    static class Score {
        int num, cnt;

        Score(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}