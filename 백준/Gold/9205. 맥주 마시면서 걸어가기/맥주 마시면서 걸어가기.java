import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        Point home, destination;
        List<Point> stores = new ArrayList<>();

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            stores = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                Point store = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                stores.add(store);
            }

            st = new StringTokenizer(br.readLine());
            destination = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            boolean isSuccess = bfs(home, stores, destination);

            if (isSuccess) sb.append("happy\n");
            else sb.append("sad\n");
        }

        System.out.println(sb);
    }

    private static boolean bfs(Point home, List<Point> stores, Point destination) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(home);
        boolean visited[] = new boolean[stores.size()];

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (Math.abs(current.x - destination.x) + Math.abs(current.y - destination.y) <= 1000) return true;

            for (int i = 0; i < stores.size(); i++) {
                if (!visited[i]) {
                    Point store = stores.get(i);
                    int distance = Math.abs(current.x - store.x) + Math.abs(current.y - store.y);

                    if (distance <= 1000) {
                        visited[i] = true;
                        queue.offer(store);
                    }
                }
            }
        }
        return false;
    }

}
