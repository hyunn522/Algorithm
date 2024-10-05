import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(input.nextToken());
        int newScore = Integer.parseInt(input.nextToken());
        int p = Integer.parseInt(input.nextToken());
        Integer[] scoreList = new Integer[n];

        if (n == 0) {
            System.out.println(1);
            return;
        }
        
        StringTokenizer scores = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scoreList[i] = (Integer.parseInt(scores.nextToken()));
        }
        
        Arrays.sort(scoreList, Collections.reverseOrder());
        
        if (n == p && scoreList[n - 1] >= newScore) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (newScore > scoreList[i]) {
                System.out.println(i + 1);
                return;
            } else if (newScore == scoreList[i]) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(n + 1);
    }
}
