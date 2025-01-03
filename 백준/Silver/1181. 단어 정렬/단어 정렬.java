import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] word = new String[n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            word[i] = str;
        }

        br.close();

        Arrays.sort(word, (w1, w2) -> {
            if (w1.length() == w2.length()) {
                return w1.compareTo(w2);
            } else {
                return w1.length() - w2.length();
            }
        });

        for (int i = 0; i < n; i++) {
            if (i > 0 && word[i].equals(word[i - 1])) {
                continue;
            }
            sb.append(word[i]).append("\n");
        }

        System.out.println(sb);
    }

}
