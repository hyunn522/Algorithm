import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int answer = 0;

        Set<Long> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            set.add(Long.parseLong(st.nextToken()));
            answer++;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            set.add(Long.parseLong(st.nextToken()));
            answer++;
        }

        System.out.println(set.size() - (answer - set.size()));
    }
}
