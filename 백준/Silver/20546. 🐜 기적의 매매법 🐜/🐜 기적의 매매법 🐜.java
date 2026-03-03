import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stocks = new int[15];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 14; i++) {
            stocks[i] = Integer.parseInt(st.nextToken());
        }

        Stock jh = new Stock(0, 0);
        Stock sm = new Stock(0, 0);
        jh.cash = sm.cash = n;

        for (int i = 1; i <= 14; i++) {
            int today = stocks[i];

            // 준현: 살 수 있으면 최대한 매수
            if (jh.cash >= today) {
                int buyCnt = jh.cash / today;
                jh.cash -= buyCnt * today;
                jh.cnt += buyCnt;
            }

            // 성민: 3일 연속 상승이면 전량 매도, 3일 연속 하락이면 즉시 전량 매수
            if (i >= 4) {
                if (stocks[i] > stocks[i - 1] && stocks[i - 1] > stocks[i - 2] && stocks[i - 2] > stocks[i - 3]) {
                    // 전량 매도
                    if (sm.cnt > 0) {
                        sm.cash += sm.cnt * today;
                        sm.cnt = 0;
                    }
                } else if (stocks[i] < stocks[i - 1] && stocks[i - 1] < stocks[i - 2] && stocks[i - 2] < stocks[i
                        - 3]) {
                    // 전량 매수
                    if (sm.cash >= today) {
                        int buyCnt = sm.cash / today;
                        sm.cash -= buyCnt * today;
                        sm.cnt += buyCnt;
                    }
                }
            }
        }

        int jhSum = jh.cash + jh.cnt * stocks[14];
        int smSum = sm.cash + sm.cnt * stocks[14];

        if (jhSum > smSum) {
            System.out.println("BNP");
        } else if (jhSum < smSum) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    static class Stock {
        int cash;
        int cnt;

        Stock(int cash, int cnt) {
            this.cash = cash;
            this.cnt = cnt;
        }
    }
}