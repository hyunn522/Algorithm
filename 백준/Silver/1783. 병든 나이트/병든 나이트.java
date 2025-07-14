import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        if (n == 1) {
            answer = 1;
        } else if (n == 2) {
            answer = Math.min(4, (m + 1) / 2);
        } else if (m < 7)  {
            answer = Math.min(4, m);
        } else {
            answer = m - 2;
        }

        System.out.println(answer);
    }
}
