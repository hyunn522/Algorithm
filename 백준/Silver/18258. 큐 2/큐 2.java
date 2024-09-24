import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < input; i++) {
            StringTokenizer command = new StringTokenizer(br.readLine());

            switch (command.nextToken()) {
                case "push": {
                    if (command.hasMoreTokens()) {
                        queue.offer(Integer.parseInt(command.nextToken()));
                        break;
                    }
                }
                case "pop": {
                    if (!queue.isEmpty()) {
                        sb.append(queue.pop() + "\n");
                    } else {
                        sb.append(-1 + "\n");
                    }
                    break;
                }
                case "size": {
                    sb.append(queue.size() + "\n");
                    break;
                }
                case "empty": {
                    if (queue.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                }
                case "front": {
                    if (queue.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(queue.peek() + "\n");
                    }
                    break;
                }
                case "back": {
                    if (queue.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(queue.peekLast() + "\n");
                    }
                    break;
                }
                default:
                    break;
            }
        }
            
        br.close();
        System.out.println(sb);
    }
}