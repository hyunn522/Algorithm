import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        while (n > 0) {
            if (n % 5 == 0) { // 5kg으로 모두 가능
                answer += n / 5;
                break;
            }

            if (n < 3) { //3kg도 불가능
                answer = -1;
                break;
            }

            n -= 3; // 5kg으로 불가능할 때 3kg
            answer++;
        }

        System.out.println(answer);
    }
}