import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> dequeue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(input.nextToken());
            switch (command) {
                case 1:
                    dequeue.addFirst(Integer.parseInt(input.nextToken()));
                    break;
                case 2:
                    dequeue.addLast(Integer.parseInt(input.nextToken()));
                    break;
                case 3:
                    if (dequeue.size() > 0)
                        sb.append(dequeue.pollFirst() + "\n");
                    else
                        sb.append(-1 + "\n");
                    break;
                case 4:
                    if (dequeue.size() > 0)
                        sb.append(dequeue.pollLast() + "\n");
                    else
                        sb.append(-1 + "\n");
                    break;
                case 5:
                    sb.append(dequeue.size() + "\n");
                    break;
                case 6:
                    if (dequeue.size() == 0)
                        sb.append(1 + "\n");
                    else
                        sb.append(0 + "\n");
                    break;
                case 7:
                    if (dequeue.size() > 0)
                        sb.append(dequeue.peekFirst() + "\n");
                    else
                        sb.append(-1 + "\n");
                    break;
                case 8:
                    if (dequeue.size() > 0)
                        sb.append(dequeue.peekLast() + "\n");
                    else
                        sb.append(-1 + "\n");
                    break;
                default:
                    break;
            }
        }
        
        System.out.println(sb);
        br.close();
    }

}