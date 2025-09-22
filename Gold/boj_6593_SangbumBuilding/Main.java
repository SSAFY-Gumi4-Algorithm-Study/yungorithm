import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static int l, r, c;
	static char[][][] map;
	static int[][][] visited;
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int sz, sx, sy, ez, ex, ey;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(l == 0 && r == 0 && c == 0) {
				break;
			}
			
			map = new char[l][r][c];
			for(int z = 0; z < l; z++) {
				for(int x = 0; x < r; x++) {
					String s = br.readLine();
					for(int y = 0; y < c; y++) {
						char ch = s.charAt(y);
						map[z][x][y] = ch;
						if(ch == 'S') {
							sz = z;
							sx = x;
							sy = y;
							continue;
						}
						
						if(ch == 'E') {
							ez = z;
							ex = x;
							ey = y;
							continue;
						}
					}
				}
				
				br.readLine();
			}
			
			visited = new int[l][r][c];
			bfs(sz, sx, sy);
			
			int result = visited[ez][ex][ey];
			if(result != 0) {
				sb.append("Escaped in ").append(result).append(" minute(s).").append("\n");				
			} else {
				sb.append("Trapped!").append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
	public static void bfs(int z, int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] { z, x, y });
		visited[z][x][y] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curZ = cur[0];
			int curX = cur[1];
			int curY = cur[2];
			
			for(int i = 0; i < 6; i++) {
				int nz = curZ + dz[i];
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nz < 0 || nx < 0 || ny < 0 || nz >= l || nx >= r || ny >= c) {
					continue;
				}
				
				if(visited[nz][nx][ny] != 0 || map[nz][nx][ny] == '#') {
					continue;
				}
				
				q.offer(new int[] { nz, nx, ny });
				visited[nz][nx][ny] = visited[curZ][curX][curY] + 1;
			}
		}
	}

}
