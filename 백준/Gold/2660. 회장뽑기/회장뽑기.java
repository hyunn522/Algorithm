import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dist = new int[n][n]; // 각 노드 간의 최단 거리

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 50);
            dist[i][i] = 0;
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (a == -2 && b == -2) break;

            dist[a][b] = dist[b][a] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    dist[a][b] = Math.min(dist[a][b], dist[a][i] + dist[i][b]);
                }
            }
        }

        List<int[]> answers = new ArrayList<>(); // 노드 번호와 최댓값 저장
        for (int i = 0; i < n; i++) {
            int result = 0;
            for (int d : dist[i]) {
                result = Math.max(result, d);
            }
            answers.add(new int[]{i, result});
        }

        answers.sort(Comparator.comparingInt(o -> o[1]));

        int min = answers.get(0)[1];
        answers.removeIf(answer -> answer[1] > min);
        answers.sort(Comparator.comparingInt(o -> o[1]));

        sb.append(min + " " + answers.size() + "\n");
        for (int[] answer : answers) {
            sb.append(answer[0] + 1 + " ");
        }

        System.out.println(sb);
    }
}