import java.io.*;
import java.util.*;

public class Main { 
	
	static int[][] map;
	static Set<Integer> set;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static final int SIZE = 5;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[SIZE][SIZE];
		set = new HashSet<>();
		
		for (int i = 0; i < SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				bfs(i, j);
			}
		}
		
		System.out.println(set.size());
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y, map[x][y], 1});
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curNum = cur[2];
			int curCnt = cur[3];
			
			if (curCnt == 6) {
				set.add(curNum);
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;
				
				int nextNum = curNum * 10 + map[nx][ny];
				queue.offer(new int[] {nx, ny, nextNum, curCnt + 1});
			}
		}
	}
}
