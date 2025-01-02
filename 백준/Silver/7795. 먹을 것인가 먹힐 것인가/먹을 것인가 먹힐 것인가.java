import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] fishA = new int[n];
            int[] fishB = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                fishA[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                fishB[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(fishB);

            int temp = 0;
            for (int j = 0; j < n; j++) {
                int low = 0;
                int high = m - 1;
                int cnt = 0;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (fishB[mid] < fishA[j]) {
                        low = mid + 1;
                        cnt = mid + 1;
                    } else high = mid - 1;
                }
                temp += cnt;
            }
            sb.append(temp).append("\n");
        }
        br.close();

        System.out.println(sb);
    }

}
