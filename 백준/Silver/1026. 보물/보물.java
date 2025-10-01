import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for (int i = 0; i < n; i++) {
            answer += arrA[i] * arrB[n - i - 1];
        }

        System.out.println(answer);
    }
}
