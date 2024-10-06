import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(scores);
        int slicedNum = (int) Math.round(n * 0.15);

        int answer = 0;
        for (int i = slicedNum; i < n - slicedNum; i++) {
            answer += scores[i];
        }

        answer = (int)Math.round((double)answer / (n - 2 * slicedNum));
        
        System.out.println(answer);
    }
}
