import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] line = new int[m];
        int[] linePackage = new int[m];
        int lineMin = Integer.MAX_VALUE;
        int linePackageMin = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            linePackage[i] = Integer.parseInt(st.nextToken());
            line[i] = Integer.parseInt(st.nextToken());

            lineMin = Math.min(lineMin, line[i]);
            linePackageMin = Math.min(linePackageMin, linePackage[i]);
        }

        if (lineMin * 6 <= linePackageMin) { // 모두 낱개로 구매
            System.out.println(lineMin * n);
        } else {
            int maxPackage = (n / 6) * linePackageMin; // 패키지로 구매할 수 있을 만큼은 구매
            if ((n % 6) * lineMin <= linePackageMin) { // 남은 기타줄을 낱개로 구매하는 것이 싼 경우
                System.out.println(maxPackage + (n % 6) * lineMin);
            } else {
                System.out.println(maxPackage + linePackageMin);
            }
        }
    }
}
