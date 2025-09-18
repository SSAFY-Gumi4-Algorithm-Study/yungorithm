import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, k;
	static char[][] map;
	static int[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new char[n + 1][m + 1];
		for(int i = 1; i <= n; i++) {
			String s = br.readLine();
			for(int j = 1; j <= m; j++) {
				map[i][j] = s.charAt(j - 1);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int ex = Integer.parseInt(st.nextToken());
		int ey = Integer.parseInt(st.nextToken());
		
		visited = new int[n + 1][m + 1];
		for(int i = 1; i <= n; i++) {
			Arrays.fill(visited[i], -1);
		}
		
		System.out.println(bfs(sx, sy, ex, ey));

	}
	
	public static int bfs(int x, int y, int ex, int ey) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] { x, y });
		visited[x][y] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			if(curX == ex && curY == ey) {
				return visited[curX][curY];
			}
			
			for(int i = 0; i < 4; i++) {
				for(int s = 1; s <= k; s++) {
					int nx = curX + dx[i] * s;
					int ny = curY + dy[i] * s;
					
					if(nx < 1 || ny < 1 || nx > n || ny > m) {
						break;
					}
					
					if(map[nx][ny] == '#') {
						break;
					}
					
					// 이미 적은 값을 가지고 있으면 굳이 갱신할 필요 없으므로 break
					if(visited[nx][ny] != -1 && visited[nx][ny] < visited[curX][curY] + 1) {
						break;
					}
					
					// 이미 방문한 칸이면 건너뛰고 다음 지점으로 이동
					if(visited[nx][ny] == visited[curX][curY] + 1) {
						continue;
					}
					
					q.offer(new int[] { nx, ny });
					visited[nx][ny] = visited[curX][curY] + 1;
				}	
			}
		}
		
		return -1;
	}

}
