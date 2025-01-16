import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static ArrayList<Node> house = new ArrayList<>();
    private static ArrayList<Node> chicken = new ArrayList<>();
    private static boolean[] chickenVisited;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) house.add(new Node(i, j));
                else if (input == 2) chicken.add(new Node(i, j));
            }
        }
        br.close();

        chickenVisited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void dfs(int count, int idx) {
        if (count == m) {
            // 치킨 거리의 최솟값 구함
            int result = 0;

            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (chickenVisited[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        temp = Math.min(temp, distance);
                    }
                }
                result += temp;
            }
            answer = Math.min(answer, result);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            chickenVisited[i] = true;
            dfs(count + 1, i + 1);
            chickenVisited[i] = false;
        }
    }

}
