import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] nAsChars = br.readLine().toCharArray();
        List<Integer> nAsIntegers = new ArrayList<>();

        int sum = 0;
        for (char c : nAsChars) {
            int i = c - '0';
            nAsIntegers.add(i);
            sum += i;
        }

        if (sum % 3 != 0 || !nAsIntegers.contains(0)) {
            System.out.println(-1);
            return;
        }

        Collections.sort(nAsIntegers, Collections.reverseOrder());
        for (Integer i : nAsIntegers) {
            sb.append(i);
        }

        System.out.print(sb);
    }
}
