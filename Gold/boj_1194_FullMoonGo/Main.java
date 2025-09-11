import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int x;
		int y;
		int key;
		
		public Node(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}
	
	static int n, m;
	static char[][] maze;
	static int[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1 ,1 };
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		maze = new char[n][m];
		int sx = -1;
		int sy = -1;
		for(int i = 0; i < n; i++) {
			char[] str = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				char ch = str[j];
				if(ch == '0') {
					sx = i;
					sy = j;
					maze[i][j] = '.';
					continue;
				}
				
				maze[i][j] = ch;
			}
		}
		
		visited = new int[n][m][64];
		for(int[][] a : visited) {
			for(int[] b : a) {
				Arrays.fill(b, -1);
			}
		}
		
		System.out.println(bfs(sx, sy));

	}
	
	public static int bfs(int sx, int sy) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		q.offer(new Node(sx, sy, 0));
		visited[sx][sy][0] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;
			int key = cur.key;

			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				
				char ch = maze[nx][ny];
				if(ch == '#') {
					continue;
				}
				
				int nextKeys = key;
				if(ch == '1') {
					return visited[curX][curY][key] + 1;
				} else if('a' <= ch && ch <= 'f') {
					nextKeys = key | (1 << (ch - 'a'));
				} else if('A' <= ch && ch <= 'F') {
					int need = 1 << (ch - 'A');
					if((key & need) == 0) {
						continue;
					}
				}
				
				if(visited[nx][ny][nextKeys] == -1) {
					visited[nx][ny][nextKeys] = visited[curX][curY][key] + 1;
					q.offer(new Node(nx, ny, nextKeys));
				}
			}
		}
		
		return -1;
	}

}
