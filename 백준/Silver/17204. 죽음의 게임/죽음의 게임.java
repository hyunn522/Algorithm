import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { 
	
	static int n, k;
	static int[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		graph = new int[n];
		
		for (int i = 0; i < n; i++) {
			graph[i] = Integer.parseInt(br.readLine());
		}
		
		// k가 되기 위한 가장 적은 횟수 구하기
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<int[]> queue = new ArrayDeque();
		queue.offer(new int[] {0, 0}); // 현재 사람의 번호, 이때까지의 cnt
		boolean[] visited = new boolean[n];
		visited[0] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curNum = cur[0];
			int curCnt = cur[1];
			
			if (curNum == k) {
				return curCnt;
			}
			
			int next = graph[curNum];
			if (!visited[next]) {
				queue.offer(new int[] {next, curCnt + 1});
				visited[next] = true;
			}

		}
		
		return -1;
	}
}
