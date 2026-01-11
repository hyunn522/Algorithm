import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int line = 1;
        int sum = 0;

        while (true) {
            if (X <= sum + line) {
                int pos = X - sum;

                if (line % 2 == 0) {
                    System.out.println(pos + "/" + (line - pos + 1));
                } else {
                    System.out.println((line - pos + 1) + "/" + pos);
                }
                break;
            }
            sum += line;
            line++;
        }
    }
}