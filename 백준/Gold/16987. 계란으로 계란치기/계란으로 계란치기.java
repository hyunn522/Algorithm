import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static Egg[] eggs;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int power = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(power, weight);
        }
        br.close();

        hit(0);

        System.out.println(result);
    }

    private static void hit(int idx) {
        if (idx == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (eggs[i].power <= 0) {
                    sum++;
                }
            }
            result = Math.max(result, sum);
            return;
        }

        if (eggs[idx].power > 0) { // 현재 손에 든 계란이 깨지지 않음
            boolean nextExists = false;

            for (int i = 0; i < n; i++) {
                if (idx == i) continue; // 손에 든 계란인 경우
                if (eggs[i].power <= 0) continue; // 계란이 깨져있는 경우

                nextExists = true;

                eggs[idx].power -= eggs[i].weight;
                eggs[i].power -= eggs[idx].weight;
                hit(idx + 1);

                // 여러 케이스 계산을 위해 원복
                eggs[idx].power += eggs[i].weight;
                eggs[i].power += eggs[idx].weight;
            }

            if(!nextExists) hit(idx + 1); // 칠 계란이 없는 경우 다음 계란을 쥠
        } else {
            hit(idx + 1);
        }
    }

}

class Egg {
    int power;
    int weight;

    public Egg(int power, int weight) {
        this.power = power;
        this.weight = weight;
    }
}
