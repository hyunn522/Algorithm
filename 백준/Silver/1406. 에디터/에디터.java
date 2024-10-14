import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        int m = Integer.parseInt(br.readLine());
        
        LinkedList<Character> leftStack = new LinkedList<>();
        LinkedList<Character> rightStack = new LinkedList<>();

        for (char c : input) {
            leftStack.push(c);
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            String command = str.nextToken();
            switch (command) {
                case "P":
                    leftStack.push(str.nextToken().toCharArray()[0]);
                    break;
                case "L":
                    if (leftStack.size() > 0)
                        rightStack.push(leftStack.pop());
                    break;
                case "D":
                    if (rightStack.size() > 0)
                        leftStack.push(rightStack.pop());
                    break;
                case "B":
                    if (leftStack.size() > 0)
                        leftStack.pop();
                    break;
                default:
                    break;
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }
        
        bw.flush();
        br.close();
    }
}
