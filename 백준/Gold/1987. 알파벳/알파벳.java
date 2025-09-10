import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { 
	
	static int r, c, answer = 1;
	static char[][] board;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        
        for (int i = 0; i < r; i++) {
        	String input = br.readLine();
        	for (int j = 0; j < c; j++) {
        		board[i][j] = input.charAt(j);
        	}
        }
        
        int startBit = 1 << (board[0][0] - 'A');
        dfs(0, 0, startBit, 1);
        System.out.println(answer);
	}
	
	static void dfs(int x, int y, int mask, int depth) {
		answer = Math.max(answer, depth);
			
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
			
			int bit = 1 << (board[nx][ny] - 'A');
			if ((mask & bit) != 0) continue; // 이미 등장한 알파벳이면 이동 불가
			
			dfs(nx, ny, mask | bit, depth + 1); 
		}
	}
}
