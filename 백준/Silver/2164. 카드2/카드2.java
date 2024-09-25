import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i=1; i<(n+1);i++){
            queue.addLast(i);
        }

        solution(queue);
    }
            

    static void solution(LinkedList<Integer> queue) {
        while (true) {
            if (queue.size() == 1)
                break;
            queue.pollFirst();
            int num = queue.pollFirst();
            queue.addLast(num);
        }
        
        System.out.println(queue.poll());
    }
}