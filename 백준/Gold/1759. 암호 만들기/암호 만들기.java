import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int l, c;
    private static List<String> chars;

    private static String[] result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        result = new String[l];
        chars = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            chars.add(st.nextToken());
        }
        br.close();
        Collections.sort(chars);

        dfs(0, 0, 0);

        System.out.println(sb);
    }

    private static void dfs(int start, int depth, int vowelCnt) {
        if (depth == l) {
            if (vowelCnt >= 1 && depth - vowelCnt >= 2) {
                for (String s : result) {
                    sb.append(s);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < chars.size(); i++) {
            result[depth] = chars.get(i);
            if (isVowels(chars.get(i))) {
                dfs(i + 1, depth + 1, vowelCnt + 1);
            } else {
                dfs(i + 1, depth + 1, vowelCnt);
            }
        }
    }

    private static boolean isVowels(String s) {
        return s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u");
    }

}
