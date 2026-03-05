import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Comparator.reverseOrder());

        int answer = -1;
        for (int i = 0; i < n - 2; i++) {
            int a = list.get(i);
            int b = list.get(i + 1);
            int c = list.get(i + 2);
            if (b + c > a) {
                answer = a + b + c;
                break;
            }
        }

        System.out.println(answer);
    }
}
