import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = 0;

        do {
            String input = br.readLine();
            if (input.equals("."))
                break;
            // input string에 대해 yes인 경우
            // case 1. (, [가 모두 없을 때
            // case 2. 
            Stack<Integer> smallStack = new Stack<>();
            Stack<Integer> bigStack = new Stack<>();
            boolean isValid = true;
            
            for (char c : input.toCharArray()) {
                if (c == '(') {
                    smallStack.push(index);
                } else if (c == '[') {
                    bigStack.push(index);
                } else if (c == ')') {
                    if (smallStack.isEmpty()
                            || (!bigStack.isEmpty() && bigStack.lastElement() > smallStack.lastElement())) {
                        isValid = false;
                        break;
                    } else smallStack.pop();
                } else if (c == ']') {
                    if (bigStack.isEmpty()
                            || (!smallStack.isEmpty() && smallStack.lastElement() > bigStack.lastElement())) {
                        isValid = false;
                        break;
                    } else
                        bigStack.pop();
                }
                index += 1;
            }

            if (!smallStack.isEmpty() || !bigStack.isEmpty()) {
                isValid = false;
            }
            
            if (isValid)
                sb.append("yes\n");
            else 
                sb.append("no\n");
            
        } while (true);
            
        br.close();
        System.out.println(sb);
    }
}