import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n;
    static char[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = br.readLine().toCharArray();
        visited = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int pos) {
        if (map[pos] == 'W') {
            return;
        }

        Deque<Character> stack = new ArrayDeque<>();
        stack.push(map[pos]);
        visited[pos] = true;
        boolean isInArea = false;

        while (pos < n - 1) {
            pos++;
            char nextChar = map[pos];

            if (nextChar == 'W') {
                isInArea = true;
                visited[pos] = true;
            } else {
                if (isInArea) {
                    break;
                }

                visited[pos] = true;
                stack.push(map[pos]);
            }
        }

    }

}