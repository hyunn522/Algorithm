import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        // 스택 구현
        ArrayList<Integer> stack = new ArrayList<>();

        for (int i = 0; i < input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    if (st.hasMoreTokens()) {
                        stack.add(Integer.parseInt(st.nextToken()));
                    }
                    break;
                case 2:
                    if (stack.size() > 0) {
                        System.out.println(stack.get(stack.size() - 1));
                        stack.remove(stack.size() - 1);
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case 3:
                    System.out.println(stack.size());
                    break;
                case 4:
                    if (stack.size() == 0) System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case 5:
                    if (stack.size() > 0) 
                        System.out.println(stack.get(stack.size() - 1));
                     else 
                        System.out.println(-1);
                    break;
            }
        }
    }
}
