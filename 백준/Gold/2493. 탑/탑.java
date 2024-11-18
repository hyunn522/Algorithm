import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 탑의 번호와 높이를 배열로 저장
        Stack<int[]> towers = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());

            // 현재 탑보다 낮은 탑 제거
            while (!towers.isEmpty() && towers.peek()[1] < height) {
                towers.pop();
            }

            if (towers.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(towers.peek()[0] + " ");
            }

            towers.push(new int[]{i + 1, height});
        }

        System.out.println(sb);
        
    }
}
