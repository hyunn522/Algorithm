import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n, time = 0;
    static int[][] board;
    static Deque<int[]> snake = new ArrayDeque<>(); // 뱀의 몸 좌표들 저장
    static int dirIdx = 0;
    static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        board = new int[n][n]; // 0 = 빈 칸, 1 = 사과, 2 = 뱀

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            board[row][col] = 1;
        }

        // 뱀 위치 초기화
        board[0][0] = 2;
        snake.offer(new int[]{0, 0});

        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int dirTime = Integer.parseInt(st.nextToken());
            String dirChar = st.nextToken();

            // (dirTime - time)초 동안 이동
            while (time < dirTime && !snake.isEmpty()) {
                time++;
                if (!moveAndCheck()) {
                    return;
                }
            }

            // dirChar에 따라 L/D로 90도 회전
            if (dirChar.equals("L")) {
                dirIdx = (dirIdx + 3) % 4;
            } else {
                dirIdx = (dirIdx + 1) % 4;
            }
        }

        while (true) {
            time++;
            if (!moveAndCheck()) {
                return;
            }
        }
    }

    static boolean moveAndCheck() {
        // 현재 방향대로 머리를 다음 칸으로 이동
        int[] curHead = snake.peekFirst();
        int nx = curHead[0] + dx[dirIdx];
        int ny = curHead[1] + dy[dirIdx];

        // 벽 or 자기자신과 부딪히면 break
        if ((nx < 0 || ny < 0 || nx >= n || ny >= n) || board[nx][ny] == 2) {
            System.out.println(time);
            return false;
        }

        // 이동한 칸이 빈 칸 -> 꼬리 칸도 0
        if (board[nx][ny] == 0) {
            int[] tail = snake.removeLast();
            board[tail[0]][tail[1]] = 0;
        }

        // 머리 이동
        board[nx][ny] = 2;
        snake.addFirst(new int[]{nx, ny});

        return true;
    }
}
