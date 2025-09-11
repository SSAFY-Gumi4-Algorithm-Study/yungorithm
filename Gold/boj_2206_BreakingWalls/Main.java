import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int x;
		int y;
		int broken;
		
		public Node(int x, int y, int broken) {
			this.x = x;
			this.y = y;
			this.broken = broken;
		}
	}
	
	static int n, m;
	static int[][] map;
	static int[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1 ,1 };

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			char[] str = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				map[i][j] = str[j] - '0';
			}
		}
		
		visited = new int[n][m][2];
		System.out.println(bfs());

	}
	
	public static int bfs() {
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		q.offer(new Node(0, 0, 0));
		visited[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			int curX = cur.x;
			int curY = cur.y;
			int broken = cur.broken;
			
			if(curX == n - 1 && curY == m - 1) {
				return visited[curX][curY][broken];
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				
				if(map[nx][ny] == 0) {
					if(visited[nx][ny][broken] == 0) {
						visited[nx][ny][broken] = visited[curX][curY][broken] + 1;
						q.offer(new Node(nx, ny, broken));
					}
				} else {
					if(broken == 0 && visited[nx][ny][1] == 0) {
						visited[nx][ny][1] = visited[curX][curY][0] + 1;
						q.offer(new Node(nx, ny, 1));
					}
				}
			}
		}
		
		return -1;
	}

}
