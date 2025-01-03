import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long number = Long.parseLong(br.readLine());
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        br.close();

        int max = -1;
        long num = 0;
        for (long l : map.keySet()) {
            if (map.get(l) > max) {
                max = map.get(l);
                num = l;
            } else if (map.get(l) == max) {
                num = Math.min(l, num);
            }
        }

        System.out.println(num);
    }

}
