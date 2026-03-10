import java.io.*;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] splitResult = br.readLine().split("\\.");
            treeMap.merge(splitResult[1], 1, Integer::sum);
        }

        for (String key : treeMap.keySet()) {
            System.out.println(key + " " + treeMap.get(key));
        }
    }
}
