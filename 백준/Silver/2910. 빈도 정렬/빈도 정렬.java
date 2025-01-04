import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayList<Long> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr.add(Long.parseLong(st.nextToken()));
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1); // 각 숫자별 빈도 저장
        }
        br.close();

        ArrayList<Long> sortedArr = new ArrayList<>(map.keySet());

        // 빈도에 따라 정렬
        sortedArr.sort((n1, n2) -> {
            if (map.get(n1).equals(map.get(n2))) {
                return arr.indexOf(n1) - arr.indexOf(n2);
            } else {
                return Integer.compare(map.get(n2), map.get(n1));
            }
        });

        for (long number : sortedArr) {
            int cnt = map.get(number);
            for (int i = 0; i < cnt; i++) {
                sb.append(number + " ");
            }
        }
        System.out.println(sb);
    }

}
