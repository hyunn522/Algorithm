import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] inputs = br.readLine().toCharArray();
        Stack<String> stack = new Stack<>();
        int temp = 1;
        int answer = 0;

        for (int i = 0; i < inputs.length; i++) {
            char c = inputs[i];
            if (c == '(') {
                stack.push("(");
                temp *= 2;
            } else if (c == '[') {
                stack.push("[");
                temp *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || !stack.peek().equals("(")) {
                    answer = 0;
                    break;
                }
                if (inputs[i - 1] == '(') {
                    answer += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || !stack.peek().equals("[")) {
                    answer = 0;
                    break;
                }
                if (inputs[i - 1] == '[') {
                    answer += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
