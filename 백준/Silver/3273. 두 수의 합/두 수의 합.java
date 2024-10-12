import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer input = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer = 0;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == x) {
                answer++;
                start++;
            }
            else if (sum < x)
                start++;
            else
                end--;
        }

        br.close();
        System.out.println(answer);
    }
}
