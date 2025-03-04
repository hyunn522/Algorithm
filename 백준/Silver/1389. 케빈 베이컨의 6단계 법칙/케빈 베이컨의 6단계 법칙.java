import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] relation = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) relation[i][j] = 0;
                else relation[i][j] = MAX;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            relation[a][b] = 1;
            relation[b][a] = 1;
        }

        for (int person = 0; person < n; person++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (relation[i][j] > relation[i][person] + relation[person][j]) {
                        relation[i][j] = relation[i][person] + relation[person][j];
                    }
                }
            }
        }

        int min = MAX;
        int answer = -1;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += relation[i][j];
            }

            if (sum < min) {
                min = sum;
                answer = i;
            }
        }
        System.out.println(answer + 1);
    }

}
