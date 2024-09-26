import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 자료구조의 개수
        int n = Integer.parseInt(br.readLine());

        // 자료구조들의 타입
        int[] types = new int[n];

        // 각 자료구조의 초기값
        int[] initValues = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            types[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            initValues[i] = Integer.parseInt(st.nextToken());
        }

        // 삽입할 숫자의 개수
        int num = Integer.parseInt(br.readLine());

        // 삽입할 숫자들의 배열
        int[] newValues = new int[num];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            newValues[i] = Integer.parseInt(st.nextToken());
        }
        
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (types[i] == 0)
                queue.addLast(initValues[i]);
        }
        
        for (int i = 0; i < num; i++) {
            queue.addFirst(newValues[i]);
            sb.append(queue.pollLast() + " ");
        }

        br.close();
        System.out.println(sb);
    }

}