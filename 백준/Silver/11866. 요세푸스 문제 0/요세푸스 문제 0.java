import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int k = Integer.parseInt(input.nextToken());
        br.close();

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i < (n + 1); i++) {
            queue.addLast(i);
        }

        solution(queue, n, k);
    }

    static void solution(LinkedList<Integer> queue, int n, int k) {
        String result = "<";

        while (queue.size() > 0) {
            for (int i = 0; i < k - 1; i++) {
                int temp = queue.poll();
                queue.add(temp);
            }
            
            int num = queue.poll();
            result += num;
            if (queue.size() > 0)
                result += ", ";
        }
        
        result += ">";
        System.out.println(result);
    }
}