import java.io.*;
import java.util.HashMap;

public class Main {
    static HashMap<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(solve(n));
    }

    private static long solve(long n) {
        if (n <= 1) {
            return 0;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        long result = Math.min((n % 3) + solve(n / 3), (n % 2) + solve(n / 2)) + 1;

        map.put(n, result);
        return result;
    }
}