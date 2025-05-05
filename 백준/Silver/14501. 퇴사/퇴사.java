import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, answer = 0;
    static Counsel[] counsels;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        counsels = new Counsel[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            counsels[i] = new Counsel(t, p);
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int index, int sum) {
        if (index == n) {
            answer = Math.max(answer, sum);
            return;
        }

        // case 1) 현재 날짜에서 상담을 하는 경우
        int newIndex = index + counsels[index].time;
        if (newIndex <= n) {
            dfs(newIndex, sum + counsels[index].price);
        }

        // case 2) 현재 날짜에서 상담을 하지 않는 경우
        dfs(index + 1, sum);
    }

    static class Counsel {
        int time, price;

        Counsel(int time, int price) {
            this.time = time;
            this.price = price;
        }
    }

}
