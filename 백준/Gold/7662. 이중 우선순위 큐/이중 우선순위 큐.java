import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>(); // {n, 횟수}

            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (op.equals("I")) {
                    // n 삽입
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }

                    int key = n == 1 ? map.lastKey() : map.firstKey();
                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.merge(key, -1, Integer::sum);
                    }
                }
            }

            sb.append((map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey()) + "\n");
        }

        System.out.println(sb);
    }
}