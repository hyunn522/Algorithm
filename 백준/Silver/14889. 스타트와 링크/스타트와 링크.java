import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] power;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        power = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        // 모든 조합에서의 능력치 탐색 후 두 팀의 능력치가 최소가 되는 수를 찾음
        makeTeam(0, 0);

        System.out.println(min);
    }

    private static void makeTeam(int start, int depth) {
        if (depth == n / 2) {
            int score = calculateMin();
            if (score == 0) {
                System.out.println(score);
                System.exit(0);
            }
            min = Math.min(min, score);
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeTeam(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int calculateMin() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    teamStart += power[i][j] + power[j][i];
                } else if (!visited[i] && !visited[j]){
                    teamLink += power[i][j] + power[j][i];
                }
            }
        }

        return Math.abs(teamStart - teamLink);
    }

}
