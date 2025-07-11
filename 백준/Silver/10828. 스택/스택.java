import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String order;
        int num;

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();

            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
                deque.push(num);
                continue;
            }

            switch (order) {
                case "pop":
                    sb.append(deque.isEmpty() ? -1 : deque.pop()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(deque.isEmpty() ? -1 : deque.getFirst()).append("\n");
                    break;
                default: break;
            }
        }

        System.out.println(sb);
    }
}
