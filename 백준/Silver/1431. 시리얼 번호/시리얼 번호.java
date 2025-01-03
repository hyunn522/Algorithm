import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] numbers = new String[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = br.readLine();
        }

        br.close();

        Arrays.sort(numbers, (n1, n2) -> {
            if (n1.length() != n2.length()) {
                return n1.length() - n2.length();
            } else {
                int s1 = 0;
                for (char c : n1.toCharArray()) {
                    if (c >= '0' && c <= '9') {
                        s1 += c - '0';
                    }
                }

                int s2 = 0;
                for (char c : n2.toCharArray()) {
                    if (c >= '0' && c <= '9') {
                        s2 += c - '0';
                    }
                }

                if (s1 != s2) {
                    return s1 - s2;
                } else {
                    return n1.compareTo(n2);
                }
            }
        });

        for (int i = 0; i < n; i++) {
            sb.append(numbers[i]).append("\n");
        }

        System.out.println(sb);
    }

}
