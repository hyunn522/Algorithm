import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            char[] functions = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Deque<String> deque = new LinkedList<>();

            if (!s.equals("[]")) {
                String[] elements = s.substring(1, s.length() - 1).trim().split(",");
                deque = new LinkedList<>(Arrays.asList(elements));
            }

            boolean isSuccess = true;
            boolean isOpposite = false;

            for (char function : functions) {
                if (function == 'R') {
                    isOpposite = !isOpposite;
                } else {
                    if (deque.isEmpty()) {
                        isSuccess = false;
                        break;
                    }
                    if (isOpposite) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (isSuccess) {
                sb.append("[");
                if (isOpposite) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.removeLast());
                        if (!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.removeFirst());
                        if (!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]\n");
            } else {
                sb.append("error\n");
            }
        }

        System.out.print(sb);
    }
}
