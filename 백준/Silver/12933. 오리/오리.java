import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        List<Character> list = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int idx = -1;

            if (c == 'q') {
                // 이전에 k까지 완료한 오리 있음 -> 재활용, 없으면 -> 새 오리 추가
                if (list.contains('k')) {
                    idx = list.indexOf('k');
                    list.remove(idx);
                    list.add(idx, c); // k -> q로 대체
                } else {
                    answer++;
                    list.add(c); // q 삽입
                }
            } else {
                if (c == 'u') {
                    if (list.contains('q')) {
                        idx = list.indexOf('q');
                    }
                } else if (c == 'a') {
                    if (list.contains('u')) {
                        idx = list.indexOf('u');
                    }
                } else if (c == 'c') {
                    if (list.contains('a')) {
                        idx = list.indexOf('a');
                    }
                } else if (c == 'k') {
                    if (list.contains('c')) {
                        idx = list.indexOf('c');
                    }
                }

                if (idx != -1) {
                    list.remove(idx);
                    list.add(idx, c);
                } else {
                    System.out.println(-1);
                    return;
                }
            }
        }

        boolean isValid = true;
        for (char c : list) {
            if (c != 'k') {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
