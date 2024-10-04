import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        int[][] arr = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer arrDatas = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(arrDatas.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer indexDatas = new StringTokenizer(br.readLine());
            int indexI = Integer.parseInt(indexDatas.nextToken());
            int indexJ = Integer.parseInt(indexDatas.nextToken());
            int indexX = Integer.parseInt(indexDatas.nextToken());
            int indexY = Integer.parseInt(indexDatas.nextToken());

            int sum = 0;
            for (int x = indexI - 1; x < indexX; x++) {
                for (int y = indexJ - 1; y < indexY; y++) {
                    sum += arr[x][y];
                }
            }
            System.out.println(sum);
        }
    }
}
