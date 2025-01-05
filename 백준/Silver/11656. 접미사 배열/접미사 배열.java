import java.io.*;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        br.close();

        String[] arr = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            arr[i] = word.substring(i);
        }
        Arrays.sort(arr);

        for (String s : arr) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

}
