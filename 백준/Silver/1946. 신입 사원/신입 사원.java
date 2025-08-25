import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] ranks = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                ranks[i][0] = Integer.parseInt(st.nextToken());
                ranks[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(ranks, (h1, h2) -> h1[0] - h2[0]);

            int answer = 1; // 첫 번째는 항상 합격
            int minB = ranks[0][1]; // 현재까지의 최소값
            for (int i = 1; i < n; i++) {
                if (ranks[i][1] < minB) {
                    answer++;
                    minB = ranks[i][1];
                }
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }
}
