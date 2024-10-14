import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] inputs = new String[n];


        for (int i = 0; i < n; i++) {
            inputs[i] = br.readLine();
        }
        br.close();

        for (int i = 0; i < inputs.length; i++) {
            char[] arr = inputs[i].toCharArray();
            int current = 0;
            LinkedList<Character> answers = new LinkedList<>();

            for (char c : arr) {
                if (c != '<' && c != '>' && c != '-') {
                    answers.add(current, c);
                    // System.out.println("current: " + current + " c: " + answers.get(current));
                    current++;
                } else if (c == '<') {
                    if (current > 0)
                        current--;
                } else if (c == '>') {
                    if (current < arr.length && current < answers.size())
                        current++;
                } else if (c == '-') {
                    if (current > 0 && current <= arr.length) {
                        answers.remove(current - 1);
                        current--;
                    }
                }
            }

            for (char c : answers) {
                sb.append(c);
            }
            if (i != inputs.length - 1) sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
