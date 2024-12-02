import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int l, r, c;
    static char[][][] building;
    static boolean[][][] isVisited;
    // 상하좌우 + 위/아래층
    static int[] dl = {0, 0, 0, 0, 1, -1};
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static Node start;
    static Node end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            // building 초기화
            building = new char[l][r][c];
            isVisited = new boolean[l][r][c];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    char[] inputs = br.readLine().toCharArray();
                    for (int k = 0; k < c; k++) {
                        building[i][j][k] = inputs[k];
                        if (inputs[k] == 'S') {
                            start = new Node(i, j, k, 0);
                        } else if (inputs[k] == 'E') {
                            end = new Node(i, j, k, 0);
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs();
            if (result == -1) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in " + result + " minute(s).\n");
            }
        }

        System.out.println(sb);
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start.l, start.r, start.c, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nl = current.l + dl[i];
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nl < 0 || nr < 0 || nc < 0 || nl >= l || nr >= r || nc >= c) {
                    continue;
                }

                if (current.l == end.l && current.r == end.r && current.c == end.c) {
                    return current.count;
                }

                if (!isVisited[nl][nr][nc] && building[nl][nr][nc] != '#') {
                    isVisited[nl][nr][nc] = true;
                    queue.offer(new Node(nl, nr, nc, current.count + 1));
                }
            }
        }

        return -1;
    }

    static class Node {
        private int l;
        private int r;
        private int c;
        private int count;

        public Node(int l, int r, int c, int count) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.count = count;
        }

        public int getL() {
            return this.l;
        }

        public int getR() {
            return this.r;
        }

        public int getC() {
            return this.c;
        }
    }
}
