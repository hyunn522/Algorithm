import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        coins.sort(Collections.reverseOrder());

        int result = 0;
        for (int coin : coins) {
            if (coin <= k) {
                result += (k / coin);
                k %= coin;
            }
            
            if (k == 0) break;
        }

        System.out.println(result);
    }
}