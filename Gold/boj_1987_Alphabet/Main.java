import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int r, c;
	static int[][] board;
	static boolean[] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		board = new int[r][c];
		for(int i = 0; i < r; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				board[i][j] = ch[j] - 65;
			}
		}
		
		visited = new boolean[26];
		
		cnt = 0;
		dfs(0, 0, 1);
		
		System.out.println(cnt);
		
	}
	
	public static void dfs(int x, int y, int length) {
		int curr = board[x][y];
		visited[curr] = true;
		cnt = Math.max(cnt, length);
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
				continue;
			}
			
			if(visited[board[nx][ny]]) {
				continue;
			}
			
			visited[board[nx][ny]] = true;
			dfs(nx, ny, length + 1);
			visited[board[nx][ny]] = false;
		}
	}

}
