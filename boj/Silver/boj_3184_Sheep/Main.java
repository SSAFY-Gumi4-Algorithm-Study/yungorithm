import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static int r, c, sheep, wolf;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		for(int i = 0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		visited = new boolean[r][c];
		int[] result = new int[2];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] != '#' && !visited[i][j]) {
					bfs(i, j);
					
					if(sheep > wolf) {
						result[0] += sheep;
					} else {
						result[1] += wolf;
					}
				}
			}
		}
		
		sb.append(result[0]).append(' ').append(result[1]);
		System.out.println(sb);
		
	}
	
	public static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		sheep = 0;
		wolf = 0;
		
		if(map[x][y] == 'v') wolf++;
		else if(map[x][y] == 'o') sheep++;
		
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= r || nc >= c) {
					continue;
				}
				
				if(visited[nr][nc] || map[nr][nc] == '#') {
					continue;
				}
				
				if(map[nr][nc] == 'v') wolf++;
				else if(map[nr][nc] == 'o') sheep++;
				
				q.offer(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
	}
	
}
