import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int koreanScore = Integer.parseInt(st.nextToken());
            int englishScore = Integer.parseInt(st.nextToken());
            int mathScore = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, koreanScore, englishScore, mathScore);
        }
        br.close();

        Arrays.sort(students, (s1, s2) -> {
            if (s1.koreanScore == s2.koreanScore && s1.englishScore == s2.englishScore && s1.mathScore == s2.mathScore) {
                return s1.name.compareTo(s2.name);
            } else if (s1.koreanScore == s2.koreanScore && s1.englishScore == s2.englishScore) {
                return s2.mathScore - s1.mathScore;
            } else if (s1.koreanScore == s2.koreanScore) {
                return s1.englishScore - s2.englishScore;
            } else {
                return s2.koreanScore - s1.koreanScore;
            }
        });

        for (int i = 0; i < n; i++) {
            sb.append(students[i].name).append("\n");
        }
        System.out.println(sb);
    }

}

class Student {
    String name;
    int koreanScore;
    int englishScore;
    int mathScore;

    public Student(String name, int koreanScore, int englishScore, int mathScore) {
        this.name = name;
        this.koreanScore = koreanScore;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }
}