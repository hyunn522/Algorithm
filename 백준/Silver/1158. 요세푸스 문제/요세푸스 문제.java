import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        LinkedList<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(input.nextToken());
        int k = Integer.parseInt(input.nextToken());
        br.close();

        for (int i = 0; i < n; i++) {
            queue.addLast(i + 1);
        }

        int count = 1;
        while (!queue.isEmpty()) {
            if (count % k == 0) {
                sb.append(queue.pollFirst());
                if (queue.size() != 0)
                    sb.append(", ");
            } else {
                int num = queue.pollFirst();
                queue.addLast(num);
            }
            count++;
        }

        sb.append(">");
        System.out.println(sb);
    }
}
