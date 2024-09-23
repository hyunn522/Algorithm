import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static Stack<Integer> stack = new Stack<>();
        
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                stack.push(input);
            } else {
                stack.pop();
            }
        }
        br.close();

        int result = 0;
        for (int num : stack) {
            result += num;
        }
        System.out.println(result);
    }
}