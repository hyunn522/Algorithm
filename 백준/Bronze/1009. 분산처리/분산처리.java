import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int base = a % 10;

            if (base == 0) {
                sb.append(10).append("\n");
                continue;
            }

            int exponent = b % 4;
            if (exponent == 0) {
                exponent = 4;
            }

            int result = 1;
            for (int j = 0; j < exponent; j++) {
                result = (result * base) % 10;
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}