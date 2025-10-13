import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		List<Node>[] graph = new List[v];
		boolean[] visited = new boolean[v];
		
		for (int i = 0; i < v; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			long c = Long.parseLong(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		int picked = 0;
		int answer = 0;
		
		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1])); // {노드, 가중치}
		pq.offer(new long[] {0, 0});
		
		while (!pq.isEmpty() && picked < v) {
			long[] cur = pq.poll();
			int curNode = (int)cur[0];
			long curSum = cur[1];
			
			if (visited[curNode]) {
				continue;
			}
			
			visited[curNode] = true;
			answer += curSum;
			picked++;
			
			for (Node next : graph[curNode]) {
				if (!visited[next.dest]) {
					pq.offer(new long[] {next.dest, next.weight});
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static class Node {
		int dest;
		long weight;
		
		Node(int dest, long weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}
}
