import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        switches = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            change(gender, num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(switches[i] ? 1 : 0).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void change(int gender, int num) {
        // 남학생인 경우
        if (gender == 1) {
            for (int i = 1; i <= n; i++) {
                if (i % num == 0) {
                    switches[i] = !switches[i];
                }
            }
            return;
        }

        // 여학생인 경우
        switches[num] = !switches[num];
        int idx = 1;
        while (true) {
            int left = num - idx;
            int right = num + idx;

            if ((left < 1 || right > n) || switches[left] != switches[right]) {
                break;
            }

            switches[left] = !switches[left];
            switches[right] = !switches[right];
            idx++;
        }
    }
}