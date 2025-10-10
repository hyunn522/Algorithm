import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }

        list.sort((a1, a2) -> {
            int start1 = a1[0];
            int end1 = a1[1];
            int start2 = a2[0];
            int end2 = a2[1];

            if (end1 != end2) {
                return end1 - end2;
            } else {
                return start1 - start2;
            }
        });

        int lastEnd = 0;
        int answer = 0;
        for (int[] arr : list) {
            if (arr[0] >= lastEnd) { // 겹치지 않으면 선택
                answer++;
                lastEnd = arr[1];
            }
        }

        System.out.println(answer);
    }
}
