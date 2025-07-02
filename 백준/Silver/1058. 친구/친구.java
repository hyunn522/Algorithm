import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int n;
    static List<List<Integer>> graph;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'Y') graph.get(i).add(j);
            }
        }

        int[] resultArr = new int[n];
        for (int i = 0; i < n; i++) {
            resultArr[i] = bfs(i);
        }

        int answer = Integer.MIN_VALUE;
        for (int i : resultArr) {
            answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }

    private static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        boolean[] visited = new boolean[n];
        visited[start] = true;
        int result = -1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curNum = cur[0];
            int curCnt = cur[1];

            if (curCnt > 2) continue;

            result++;
            for (int next : graph.get(curNum)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, curCnt + 1});
                }
            }
        }

        return result;
    }
}