import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] numbers;
    static int[] operators;

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        calculate(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void calculate(int result, int depth) {
        if (depth == n) {
            MAX = Math.max(result, MAX);
            MIN = Math.min(result, MIN);
            return;
        }

        // 계산 후 결과 넣기
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                int nextResult = result;
                if (i == 0) nextResult += numbers[depth];
                else if (i == 1) nextResult -= numbers[depth];
                else if (i == 2) nextResult *= numbers[depth];
                else nextResult /= numbers[depth];

                calculate(nextResult, depth + 1);

                operators[i]++;
            }
        }

    }

}
