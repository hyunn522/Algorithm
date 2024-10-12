import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();

        int[] arr = new int[10];
        for (char c : input.toCharArray()) {
            if (c == '6')
                arr[9]++;
            else arr[c - '0']++;
        }

        int max = 0;

        for (int i = 0; i < 10; i++) {
            if (arr[i] > max && i != 9)
                max = arr[i];
        }

        if (arr[9] > 0) {
            if (arr[9] % 2 == 0) {
                max = Math.max(max, arr[9] / 2);
            } else {
                max = Math.max(max, arr[9] / 2 + 1);
            }
        }

        System.out.println(max);
    }
}
