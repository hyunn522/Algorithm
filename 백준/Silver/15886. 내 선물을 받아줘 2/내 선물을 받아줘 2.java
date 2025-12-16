import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] map = br.readLine().toCharArray();

        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            if (map[i] == 'E' && map[i + 1] == 'W') {
                answer++;
            }
        }

        System.out.println(answer);
    }
}