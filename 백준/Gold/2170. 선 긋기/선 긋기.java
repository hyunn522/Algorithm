import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 시작점 기준으로 오름차순 정렬
        lines.sort(Comparator.comparingInt(l -> l[0]));

        int start = lines.get(0)[0];
        int end = lines.get(0)[1];
        int answer = 0;
        for (int i = 1; i < n; i++) {
            // 겹침 -> 끝 갱신
            if (lines.get(i)[0] <= end) {
                end = Math.max(end, lines.get(i)[1]);
            } else {
                // 겹치지 않음 -> 이전 구간 확정, 새 구간 시작
                answer += end - start;
                start = lines.get(i)[0];
                end = lines.get(i)[1];
            }
        }

        answer += end - start;
        
        System.out.println(answer);
    }
}