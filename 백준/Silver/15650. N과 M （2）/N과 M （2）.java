import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        br.close();

        arr = new int[m];

        rec(1, 0);

        System.out.println(sb);
    }

    private static void rec(int start, int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            rec(i + 1, depth + 1);
        }
    }

}
