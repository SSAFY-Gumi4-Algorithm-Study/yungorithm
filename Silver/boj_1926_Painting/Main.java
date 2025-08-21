import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1 ,1 };
	static int cnt, max;
	static int result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n][m];
		
		max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(visited[i][j] || map[i][j] == 0) {
					continue;
				}
				cnt = 0;
				bfs(i, j);
				max = Math.max(max, cnt);
			}
		}
		
		sb.append(result).append("\n").append(max);
		
		System.out.println(sb);
		
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int currX = curr[0];
			int currY = curr[1];
			cnt++;
			
			for(int i = 0; i < 4; i++) {
				int nx = currX + dx[i];
				int ny = currY + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				
				if(visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}
				
				q.offer(new int[] { nx, ny });
				visited[nx][ny] = true;
				
			}
			
		}
		
		result++;
	}

}
