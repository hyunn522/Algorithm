import java.io.*;
import java.util.*;

public class Main {

	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
	static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						bfs(i, j);
						answer++;
					}
				}
			}
			sb.append(answer + "\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			for (int i = 0; i < 8; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
				
				if (!visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
	}

}
