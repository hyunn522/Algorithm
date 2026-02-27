import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 정렬 + 중복 제거
        TreeSet<Integer> set = new TreeSet<>(list);

        // 각 숫자의 좌표 압축 결과 저장
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int x : set) {
            rankMap.put(x, rank);
            rank++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(rankMap.get(list.get(i)));
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}