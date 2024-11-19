import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String> notHeard = new ArrayList<>();
        List<String> notSeen = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            notHeard.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            notSeen.add(br.readLine());
        }

        HashSet<String> differentNames = new HashSet<>(notHeard);
        List<String> duplicateNames = new ArrayList<>();
        for (String name : notSeen) {
            if (!differentNames.add(name)) {
                count++;
                duplicateNames.add(name);
            }
        }
        
        Collections.sort(duplicateNames);
        for (String name : duplicateNames) {
            sb.append(name + "\n");
        }

        System.out.println(count);
        System.out.print(sb);
    }
}
