import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int cnt = 0, turn = 0, depth = 2;

        while (true) {
            // 기본 뻔-데기-뻔-데기
            for (int i = 0; i < 4; i++) {
                if (target == i % 2) {
                    cnt++;
                    if (cnt == t) {
                        System.out.println(turn % a);
                        return;
                    }
                }
                turn++;
            }

            // 뻔 * depth
            for (int i = 0; i < depth; i++) {
                if (target == 0) {
                    cnt++;
                    if (cnt == t) {
                        System.out.println(turn % a);
                        return;
                    }
                }
                turn++;
            }

            // 데기 * depth
            for (int i = 0; i < depth; i++) {
                if (target == 1) {
                    cnt++;
                    if (cnt == t) {
                        System.out.println(turn % a);
                        return;
                    }
                }
                turn++;
            }

            depth++;
        }
    }

}
