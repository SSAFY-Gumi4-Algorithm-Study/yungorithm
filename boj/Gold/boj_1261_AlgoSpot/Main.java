import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int m, n, INF = Integer.MAX_VALUE / 4;
	static int[][] map;
	static int[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited = new int[n][m];
		for(int i = 0; i < n; i++) {
			Arrays.fill(visited[i], INF);
		}
		
		bfs(0, 0);
		
		System.out.println(visited[n - 1][m - 1]);

	}
	
	public static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] { x, y });
		visited[x][y] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				
				if(visited[nx][ny] <= visited[curX][curY] + map[nx][ny]) {
					continue;
				}
				
				q.offer(new int[] { nx, ny });
				visited[nx][ny] = Math.min(visited[nx][ny], visited[curX][curY] + map[nx][ny]);
			}
		}
	}

}
