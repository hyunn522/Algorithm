import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {

    static int n;
    static Point[] curPosition = {
            new Point(0, 0), // RR
            new Point(1, 0), // RL
            new Point(0, 1), // FR
            new Point(1, 1)}; // FL
    static int curDirection = 0; // North, East, South, West

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int minX = 0, maxX = 1;
        int minY = 0, maxY = 1;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String foot = input.substring(0, 2);
            String direction = input.substring(2);

            int footIdx = -1;
            if (foot.equals("RR")) footIdx = 0;
            else if (foot.equals("RL")) footIdx = 1;
            else if (foot.equals("FR")) footIdx = 2;
            else if (foot.equals("FL")) footIdx = 3;

            if (direction.equals("P")) {
                pivot(footIdx);
            } else {
                move(footIdx, direction);
            }

            if(isSamePosition()) {
                System.out.println(-1);
                return;
            }

            for (int j = 0; j < 4; j++) {
                minX = Math.min(minX, curPosition[j].x);
                maxX = Math.max(maxX, curPosition[j].x);
                minY = Math.min(minY, curPosition[j].y);
                maxY = Math.max(maxY, curPosition[j].y);
            }
        }

        System.out.println((maxX - minX + 1) * (maxY - minY + 1));
    }

    static void pivot(int standardIdx) {
        curDirection = (curDirection + 1) % 4;

        for (int i = 0; i < 4; i++) {
            if (i != standardIdx) {
                int dx = curPosition[i].x - curPosition[standardIdx].x;
                int dy = curPosition[i].y - curPosition[standardIdx].y;

                int newX = curPosition[standardIdx].x - dy;
                int newY = curPosition[standardIdx].y + dx;

                curPosition[i].x = newX;
                curPosition[i].y = newY;
            }
        }
    }

    static void move(int footIdx, String direction) {
        switch (direction) {
            case "F": // forward
                switch (curDirection) {
                    case 0:
                        curPosition[footIdx].y++;
                        break;
                    case 1:
                        curPosition[footIdx].x--;
                        break;
                    case 2:
                        curPosition[footIdx].y--;
                        break;
                    case 3:
                        curPosition[footIdx].x++;
                        break;
                }
                break;
            case "B": // backward
                switch (curDirection) {
                    case 0:
                        curPosition[footIdx].y--;
                        break;
                    case 1:
                        curPosition[footIdx].x++;
                        break;
                    case 2:
                        curPosition[footIdx].y++;
                        break;
                    case 3:
                        curPosition[footIdx].x--;
                        break;
                }
                break;
            case "R": // right
                switch (curDirection) {
                    case 0:
                        curPosition[footIdx].x--;
                        break;
                    case 1:
                        curPosition[footIdx].y--;
                        break;
                    case 2:
                        curPosition[footIdx].x++;
                        break;
                    case 3:
                        curPosition[footIdx].y++;
                        break;
                }
                break;
            case "L": // left
                switch (curDirection) {
                    case 0:
                        curPosition[footIdx].x++;
                        break;
                    case 1:
                        curPosition[footIdx].y++;
                        break;
                    case 2:
                        curPosition[footIdx].x--;
                        break;
                    case 3:
                        curPosition[footIdx].y--;
                        break;
                }
                break;
        }
    }

    private static boolean isSamePosition() {
        Set<Point> pointSet = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            pointSet.add(new Point(curPosition[i].x, curPosition[i].y));
        }

        return pointSet.size() != 4;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Point)) return false;
            Point point = (Point) obj;
            return this.x == point.x && this.y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
