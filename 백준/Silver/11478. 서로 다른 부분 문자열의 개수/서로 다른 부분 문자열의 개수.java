import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        Set<String> set = new HashSet<>();

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= length - i; j++) {
                set.add(s.substring(j, j + i));
            }
        }

        System.out.println(set.size());
    }
}
