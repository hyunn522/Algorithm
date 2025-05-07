import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Game> games;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        games = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String inputNum = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            games.add(new Game(inputNum, strike, ball));
        }

        int answer = 0;

        for (int i = 123; i <= 987; i++) {
            String num = String.valueOf(i);
            if (!isValid(num)) continue;

            boolean isPossible = true;
            for (Game game : games) {
                int strike = getStrike(num, game.num);
                int ball = getBall(num, game.num);
                if (strike != game.strike || ball != game.ball) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) answer++;
        }
        System.out.println(answer);
    }

    private static boolean isValid(String num) {
        return !num.contains("0") &&
                num.charAt(0) != num.charAt(1) &&
                num.charAt(1) != num.charAt(2) &&
                num.charAt(0) != num.charAt(2);
    }

    private static int getStrike(String num1, String num2) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (num1.charAt(i) == num2.charAt(i)) result++;
        }
        return result;
    }

    private static int getBall(String num1, String num2) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (num1.charAt(i) != num2.charAt(i) && num1.contains(String.valueOf(num2.charAt(i)))) result++;
        }
        return result;
    }

    static class Game {
        String num;
        int strike, ball;

        Game(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

}
