import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 끝나는 시간이 빠른 순서로 정렬
        // 동시에 끝난다면 빨리 시작하는 순서로 정렬
        times.sort((t1, t2) -> {
            if (t1[1] != t2[1]) {
                return t1[1] - t2[1];
            } else {
                return t1[0] - t2[0];
            }
        });

        int answer = 0;
        int lastTime = 0;
        for (int i = 0; i < n; i++) {
            // 현재 회의의 시작 시간이 마지막으로 선택한 회의의 종료 시간보다 이후면 현재 회의 가능
            int start = times.get(i)[0];
            if (start >= lastTime) {
                answer++;
                lastTime = times.get(i)[1]; // 마지막으로 선택한 회의의 종료 시간 갱신
            }
        }
        System.out.println(answer);
    }
}