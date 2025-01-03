import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        br.close();

        Arrays.sort(points, (p1, p2) -> {
            if (p1.x == p2.x) {
                return p1.y - p2.y;
            } else {
                return p1.x - p2.x;
            }
        });

        for (int i = 0; i < n; i++) {
            sb.append(points[i].x).append(" ").append(points[i].y).append("\n");
        }

        System.out.println(sb);
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
