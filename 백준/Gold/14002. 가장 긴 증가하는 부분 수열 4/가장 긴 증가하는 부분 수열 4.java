import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n]; // i번째 수까지의 가장 긴 증가하는 부분 수열의 길이
        int[] idxes = new int[n]; // 가장 긴 증가하는 부분 수열에서 i번째 수 이전 수의 인덱스
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        idxes[i] = j;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int maxIdx = -1;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxIdx = i;
            }
        }
        sb.append(maxLength + "\n");

        int[] maxArr = new int[maxLength];
        for (int i = maxLength - 1; i >= 0; i--) {
            maxArr[i] = arr[maxIdx];
            maxIdx = idxes[maxIdx];
        }

        for (int i : maxArr) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}