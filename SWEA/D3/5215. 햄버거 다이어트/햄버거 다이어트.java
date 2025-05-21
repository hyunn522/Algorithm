import java.util.Scanner;

class Solution {

    static int n, l, answer;
    static Ingredient[] ingredients;
    static boolean[] visited;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            l = sc.nextInt();
            ingredients = new Ingredient[n];
            visited = new boolean[n];
            answer = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int t = sc.nextInt();
                int k = sc.nextInt();
                ingredients[i] = new Ingredient(t, k);
            }

            // 칼로리 합이 l 이하이면서 점수가 최대인 경우 찾기
            dfs(0, 0, 0);

            sb.append("#" + test_case + " " + answer + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int cnt, int caloriesSum, int scoreSum) {
        if (cnt == n) {
            if (caloriesSum <= l) answer = Math.max(answer, scoreSum);
            return;
        }

        // 현재 재료를 선택하는 경우
        dfs(cnt + 1, caloriesSum + ingredients[cnt].calories, scoreSum + ingredients[cnt].score);

        // 현재 재료를 선택하지 않는 경우
        dfs(cnt + 1, caloriesSum, scoreSum);
    }

    static class Ingredient {
        int score;
        int calories;

        Ingredient(int score, int calories) {
            this.score = score;
            this.calories = calories;
        }
    }
}