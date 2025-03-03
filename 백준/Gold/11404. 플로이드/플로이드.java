import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) cost[i][j] = 0;
                else cost[i][j] = MAX;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken()) - 1;
            int endCity = Integer.parseInt(st.nextToken()) - 1;
            int newCost = Integer.parseInt(st.nextToken());
            cost[startCity][endCity] = Math.min(cost[startCity][endCity], newCost);
        }

        // 모든 도시에 대해 최소 비용 계산
        for (int city = 0; city < n; city++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][city] != MAX && cost[city][j] != MAX) {
                        int newCost = cost[i][city] + cost[city][j];
                        if (newCost < cost[i][j]) cost[i][j] = newCost;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cost[i][j] == MAX) sb.append("0 ");
                else sb.append(cost[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
