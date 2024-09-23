import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String input = br.readLine();
            // input의 각 character에 대해 (라면 push, )가 등장할 때마다 하나씩 pop -> stack이 비면 YES, 뭐라도 있으면 NO
            Stack<Integer> stack = new Stack<>();
            boolean isValid = true;
            
            for (char c : input.toCharArray()) {
                if (c == '(') {
                    stack.push(0);
                } else {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    isValid = false;
                } else
                    isValid = true;
            }
            if (isValid)
                sb.append("YES\n");
            else 
                sb.append("NO\n");
        }
        br.close();
        System.out.println(sb);
    }
}