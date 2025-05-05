import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] target, counts;
    static BookInfo[] bookInfos;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        target = new int['Z' - 'A' + 1];
        counts = new int['Z' - 'A' + 1];

        for (char ch : str.toCharArray()) {
            target[ch - 'A']++;
        }

        n = Integer.parseInt(br.readLine());
        bookInfos = new BookInfo[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int price = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            bookInfos[i] = new BookInfo(name, price);
        }

        dfs(0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? - 1 : answer);
    }

    private static void dfs(int index, int sum) {
        if (index == n) {
            if (check()) answer = Math.min(answer, sum);
            return;
        }

        // case 1) 책을 선택하지 않은 경우
        dfs(index + 1, sum);

        // case 2) 책을 선택한 경우
        for (int i = 0; i < bookInfos[index].name.length(); i++) {
            char c = bookInfos[index].name.charAt(i);
            counts[c - 'A']++;
        }

        dfs(index + 1, sum + bookInfos[index].price);

        // 복구
        for (int i = 0; i < bookInfos[index].name.length(); i++) {
            char c = bookInfos[index].name.charAt(i);
            counts[c - 'A']--;
        }
    }

    private static boolean check() {
        for (int i = 0; i < target.length; i++) {
            if (target[i] > counts[i]) return false;
        }
        return true;
    }

    static class BookInfo {
        String name;
        int price;

        BookInfo (String name, int price) {
            this.name = name;
            this.price = price;
        }
    }
}
