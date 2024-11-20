import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            char[] chars = br.readLine().toCharArray();

            for (char c : chars) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                result++;
            }
        }

        System.out.print(result);
    }
}
