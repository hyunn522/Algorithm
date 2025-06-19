import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dpUp = new int[n];
        int[] dpDown = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dpUp[0] = 1;
        dpDown[0] = 1;
        int answer = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                dpUp[i] = dpUp[i - 1] + 1;
                dpDown[i] = 1;
            } else if (arr[i] < arr[i - 1]) {
                dpUp[i] = 1;
                dpDown[i] = dpDown[i - 1] + 1;
            } else {
                dpUp[i] = dpUp[i - 1] + 1;
                dpDown[i] = dpDown[i - 1] + 1;
            }

            answer = Math.max(answer, Math.max(dpUp[i], dpDown[i]));
        }

        System.out.println(answer);
    }
}