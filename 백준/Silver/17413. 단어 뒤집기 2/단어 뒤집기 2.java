import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String answer = "";
        Deque<Character> stack = new ArrayDeque<>();
        boolean isTag = false;

        for (char c : s.toCharArray()) {
            if (c == '<' || c == '>') {
                while (!stack.isEmpty()) {
                    answer += stack.pop();
                }
                isTag = !isTag;
                answer += c;
            } else if (isTag) {
                answer += c;
            } else if (c == ' ') {
                while (!stack.isEmpty()) {
                    answer += stack.pop();
                }
                answer += " ";
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}
