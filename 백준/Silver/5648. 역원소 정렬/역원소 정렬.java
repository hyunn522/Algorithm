import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        int count = 0;
        while (count < n) {
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                String temp = "";
                for (int i = str.length() - 1; i >= 0; i--) {
                    temp += str.charAt(i);
                }
                arr[count] = Long.parseLong(temp);
                count++;
            }
            if (count < n) st = new StringTokenizer(br.readLine());
        }

        br.close();

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

}
