import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arrN, arrM;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrN = new int[n];
        arrM = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrN[i]= Integer.parseInt(st.nextToken());
        }
        br.close();
        Arrays.sort(arrN);

        rec(0);
        System.out.println(sb);
    }

    private static void rec(int depth) {
        if (depth == m) {
            for (int i : arrM) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            arrM[depth] = arrN[i];
            rec(depth + 1);
        }
    }

}
