import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		int sx = -1;
		int sy = -1;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == 2) {
					sx = i;
					sy = j;
					map[i][j] = 0;
					continue;
				}
				
				map[i][j] = value;
			}
		}
		
		visited = new boolean[n][m];
		bfs(sx, sy);
		
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					sb.append(-1).append(' ');
				} else {
					sb.append(map[i][j]).append(' ');
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static void bfs(int sx, int sy) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] { sx, sy });
		visited[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(map[nx][ny] == 0 || visited[nx][ny]) continue;
				
				map[nx][ny] = map[curX][curY] + 1;
				visited[nx][ny] = true;
				q.offer(new int[] { nx, ny });
			}
		}
	}
	
}
