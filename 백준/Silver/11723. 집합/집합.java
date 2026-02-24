import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int s = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int x = -1;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (operation) {
                case "add":
                    s |= (1 << x);
                    break;
                case "remove":
                    s &= ~(1 << x);
                    break;
                case "check":
                    sb.append((s & (1 << x)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    s ^= (1 << x);
                    break;
                case "all":
                    s = (1 << 21) - 1;
                    break;
                case "empty":
                    s = 0;
                    break;
            }
        }

        System.out.println(sb);
    }
}