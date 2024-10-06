import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        br.close();

        int n = Integer.parseInt(input);
        char[] nArr = input.toCharArray();
        int length = nArr.length;

        int answer = 0;

        int b = n - (int) Math.pow(10, length - 1) + 1;
        for (int i = 0; i < (length + 1);i ++) {
            if (i != length) {
                answer += (Math.pow(10, i) - Math.pow(10, i - 1)) * i;
            } else {
                answer += b * i;
            }
        }
        
        System.out.println(answer);
    }
}
