import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];
        int[] scores = new int[n]; // 특정 층까지의 최대 점수들

        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stairs[0]);
            return;
        }

        if (n == 2) {
            System.out.println(stairs[0] + stairs[1]);
            return;
        }

        scores[0] = stairs[0];
        scores[1] = stairs[0] + stairs[1];
        scores[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

        for (int i = 3; i < n; i++) {
            scores[i] = Math.max(scores[i - 2], scores[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(scores[n - 1]);

    }
}
