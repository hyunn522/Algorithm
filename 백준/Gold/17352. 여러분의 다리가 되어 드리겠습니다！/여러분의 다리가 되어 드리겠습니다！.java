import java.io.*;
import java.util.*;

public class Main { 
	
	static int n;
	static List<List<Integer>> map;
	static String answer = "";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			map.add(new ArrayList<>());
		}
		
		for (int i = 0; i < n - 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map.get(a).add(b);
			map.get(b).add(a);
		}
		
		for (int i = 0; i < n; i++) {
			if (bfs(i)) break; // 이어지지 않는 곳을 찾으면 끝
		}
		
		System.out.println(answer);
	}
	
	static boolean bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		boolean[] visited = new boolean[n];
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int next : map.get(cur)) {
				if (!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				answer = String.valueOf(start + 1) + " " + String.valueOf(i + 1);
				return true;
			}
		}
		
		return false;
	}
}

