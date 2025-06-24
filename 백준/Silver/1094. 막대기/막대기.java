import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int stick = 64;
        int answer = 0;
        while (x > 0) {
            if (stick > x) {
                stick /= 2;
            } else {
                x -= stick;
                answer++;
            }
        }

        System.out.println(answer);
    }
}