import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int k = Integer.parseInt(input.nextToken());
        br.close();

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);  // 처음에는 모든 수를 소수로 가정
        isPrime[0] = isPrime[1] = false;  // 0과 1은 소수가 아님

        int count = 0;  // 제거된 숫자를 카운트
        int result = 0;  // k번째로 제거된 수

        for (int p = 2; p <= n; p++) {
            if (isPrime[p]) {  // p가 아직 소수로 남아있는 경우
                for (int multiple = p; multiple <= n; multiple += p) {
                    if (isPrime[multiple]) {  // 아직 제거되지 않은 수라면
                        isPrime[multiple] = false;  // 제거
                        count++;
                        if (count == k) {
                            result = multiple;  // k번째로 제거된 수
                            break;
                        }
                    }
                }
            }
            if (count == k) break;
        }

        System.out.println(result);  // k번째로 제거된 수 출력
    }
}
