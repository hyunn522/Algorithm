import java.io.*;
import java.util.*;

public class Main { 
	
	static final int SIZE = 5;
	static int r, c, answer = -1;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[SIZE][SIZE];
		visited = new boolean[SIZE][SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		if (map[r][c] == 1) {
			System.out.println(0);
			return;
		}
		
		bfs();
		
		System.out.println(answer);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c, 0});
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curCnt = cur[2];
			
			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;
				if (visited[nx][ny] || map[nx][ny] == -1) continue;
				
				if (map[nx][ny] == 1) {
					answer = curCnt + 1;
					return;
				}
				
				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny, curCnt + 1});
			}
		}
		
	}
}

