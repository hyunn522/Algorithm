import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int size = input.length;

        int n = 1;
        int idx = 0;
        while (idx < size) {
            String s = String.valueOf(n);
            for (int i = 0; i < s.length() && idx < size; i++) {
                if (s.charAt(i) == input[idx]) {
                    idx++;
                }
            }
            n++;
        }

        System.out.println(n - 1);
    }
}