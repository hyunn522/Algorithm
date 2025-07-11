import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[8001]; // 입력값의 범위 : -4000 ~ 4000

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            arr[cur + 4000]++;
            sum += cur;

            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }

        int median = 10000;
        int mode = 10000;
        int count = 0; // 중앙값의 누적 빈도
        int modeMax = 0; // 최빈값 중 최댓값
        boolean flag = false; // 이전과 동일한 최빈값이 1번만 등장했을 경우 true, 아닐 경우 false

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (arr[i] > 0) {
                // 중앙값 찾기
                if (count < (n + 1) / 2) { // 누적 횟수가 전체 길이의 절반보다 작음 -> 계속 찾아야 함
                    count += arr[i]; // 빈도수 누적
                    median = i - 4000;
                }

                // 최빈값 찾기
                if (modeMax < arr[i]) { // 이전 최빈값보다 현재 값의 빈도수가 더 높을 경우
                    modeMax = arr[i];
                    mode = i - 4000;
                    flag = true;
                } else if (modeMax == arr[i] && flag){ // 이전의 최대 최빈값과 동일하면서 한 번만 중복되는 경우
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        System.out.println((int)Math.round((double)sum / n));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max - min);
    }
}
