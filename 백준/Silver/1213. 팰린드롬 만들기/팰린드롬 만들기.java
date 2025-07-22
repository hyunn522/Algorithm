import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] count = new int[26]; // 'A' ~ 'Z'

        // 각 문자에 대해 등장 횟수 저장
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }

        int oddCount = 0;
        char oddChar = '0';
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                oddCount++;
                oddChar = (char)('A' + i);
            }
        }

        if (oddCount > 1) { // 홀수 번 등장한 문자가 여러 개 존재
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder halfStr = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                halfStr.append((char)('A' + i));
            }
        }

        StringBuilder answer = new StringBuilder(halfStr);
        if (oddChar != '0') answer.append(oddChar);
        answer.append(halfStr.reverse());
        System.out.println(answer);
    }
}
