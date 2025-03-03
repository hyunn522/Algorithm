import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 노드를 거쳐갈 수 있는 경우 갱신
        for (int middle = 0; middle < n; middle++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j != middle && k != middle) {
                        if (graph[j][middle] + graph[middle][k] == 2) graph[j][k] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
