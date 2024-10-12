import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String result = Integer.toString(a * b * c);
        int[] nums = new int[10];
        
        for (char i : result.toCharArray()) {
            nums[i - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(nums[i]);
        }

    }
}
