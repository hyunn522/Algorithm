import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1 || n == 2) {
            System.out.println("1 0");
        } else {
            int[] recursive = new int[n];
            recursive[2] = 2;
            recursive[3] = 3;
            for (int i = 4; i < n; i++) {
                recursive[i] = recursive[i - 1] + recursive[i - 2];
            }

            System.out.println(recursive[n - 1] + " " + (n - 2));
        }
    }
}