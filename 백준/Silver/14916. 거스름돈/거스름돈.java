import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        while (true) {
            if (n % 5 == 0) {
                answer += n / 5;
                System.out.println(answer);
                return;
            } else {
                n -= 2;
                answer++;
            }

            if (n < 0) {
                System.out.println(-1);
                return;
            }
        }

    }
}