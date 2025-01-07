import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int n, w, l;
    private static int[] trucks;
    private static int[] bridge;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        trucks = new int[n];
        bridge = new int[w];

        for (int i = 0; i < w; i++) {
            bridge[i] = -1;
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        
        for (int i = 0; i < n; i++) {
            cross(i);
        }

        for (int i = 0; i < w; i++) {
            while (bridge[i] != -1) {
                timeGoes();
                result++;
            }
        }

        System.out.println(result);
    }

    private static void cross(int idx) {
        int truck = trucks[idx];
        while (true) {
            result++;
            timeGoes();

            // 현재 다리의 트럭들의 개수 및 총 무게 계산
            int currentCnt = 0;
            int currentWeight = 0;
            for (int i : bridge) {
                if (i > -1) {
                    currentCnt++;
                    currentWeight += trucks[i];
                }
            }

            // truck이 올라갈 수 없는 경우
            if (currentWeight + truck > l || currentCnt + 1 > w) {
                continue;
            }

            // truck이 올라가는 경우
            bridge[0] = idx;
            break;
        }
    }

    private static void timeGoes() {
        for (int i = w - 1; i >= 0; i--) {
            if (i > 0) {
                bridge[i] = bridge[i - 1];
            } else {
                bridge[i] = -1;
            }
        }
    }

}
