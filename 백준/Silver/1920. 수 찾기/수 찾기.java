import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (search(num)) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);
    }

    static boolean search(int num) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (num < arr[mid]) right = mid - 1;
            else if (num > arr[mid]) left = mid + 1;
            else return true;
        }

        return false;
    }
}