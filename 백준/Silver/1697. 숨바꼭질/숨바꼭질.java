import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] isVisited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{n, 0});
        isVisited[n] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            if (position == k) {
                System.out.println(time);
                return;
            }

            if (position - 1 >= 0 && !isVisited[position - 1]) {
                queue.add(new int[]{position - 1, time + 1});
                isVisited[position - 1] = true;
            }
            if (position + 1 <= 100000 && !isVisited[position + 1]) {
                queue.add(new int[]{position + 1, time + 1});
                isVisited[position + 1] = true;
            }
            if (position * 2 <= 100000 && !isVisited[position * 2]) {
                queue.add(new int[]{position * 2, time + 1});
                isVisited[position * 2] = true;
            }
        }
    }
}
