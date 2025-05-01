import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int answer = 1;
        while (a != b) {
            if ((b % 2 != 0 && b % 10 != 1) || b < a) {
                answer = -1;
                break;
            }
            
            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 10 == 1) {
                b /= 10;
            } 
            answer++;
        }

        System.out.println(answer);
    }
}
