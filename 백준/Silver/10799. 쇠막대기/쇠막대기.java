import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] inputs = br.readLine().toCharArray();

        Deque<Character> deque = new LinkedList<>();

        boolean isPrevLaser = false;
        int result = 0;
        for (char input : inputs) {
            if (input == ')') {
                if (!deque.isEmpty()) {
                    if (!isPrevLaser) {
                        isPrevLaser = true;
                        deque.poll();
                        result += deque.size();
                    } else {
                        result++;
                        deque.poll();
                    }
                }
            } else {
                isPrevLaser = false;
                deque.add(input);
            }
        }

        System.out.print(result);
    }
}
