import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dpA = new int[n + 1];
        int[] dpB = new int[n + 1];
        dpA[0] = 1;
        dpB[0] = 0;

        for (int i = 1; i <= n; i++) {
            dpA[i] = dpB[i - 1];
            dpB[i] = dpA[i - 1] + dpB[i - 1];
        }

        System.out.println(dpA[n] + " " + dpB[n]);
    }
}