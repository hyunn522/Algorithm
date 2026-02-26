import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people.add(new Person(age, name));
        }

        Collections.sort(people, (p1, p2) -> {
            if (p1 != p2) {
                return p1.age - p2.age;
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder();
        for (Person p : people) {
            sb.append(p.age + " " + p.name + "\n");
        }
        System.out.println(sb);
    }

    static class Person {
        int age;
        String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}