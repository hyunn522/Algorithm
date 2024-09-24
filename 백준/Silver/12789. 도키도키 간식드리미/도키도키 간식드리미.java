import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] lineArr = new int[n];

        StringTokenizer input = new StringTokenizer(br.readLine());

        for (int i=0; i<n;i++){
            lineArr[i] = Integer.parseInt(input.nextToken());
        }

        solution(lineArr);
    }
            

    static void solution(int[] arr) {
        int findValue = 1;
        Stack<Integer> stack = new Stack<>();
        boolean isValid = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != findValue) { // 해당 순서가 아닐 경우
                if (!stack.isEmpty() && stack.peek() == findValue) {
                    stack.pop();
                    i--;
                    findValue++;
                } else {
                    stack.push(arr[i]);
                }
            } else { // 해당 순서가 맞는 경우
                findValue++;
            }
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();

            if (pop == findValue) {
                findValue++;
            } else {
                isValid = false;
                break;
            }
        }
        System.out.println(isValid ? "Nice" : "Sad");
    }
}