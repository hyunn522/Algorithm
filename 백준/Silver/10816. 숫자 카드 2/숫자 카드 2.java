import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long[] cards = new long[20000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int cur = Integer.parseInt(st.nextToken()) + 10000000;
            sb.append(cards[cur] + " ");
        }

        System.out.println(sb);
    }
}