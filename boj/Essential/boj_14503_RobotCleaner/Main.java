import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int sX, sY, sDir;
	static int[][] room;
	static int[][] direction = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	static int result;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		sX = Integer.parseInt(st.nextToken());
		sY = Integer.parseInt(st.nextToken());
		sDir = Integer.parseInt(st.nextToken());
		
		room = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int area = Integer.parseInt(st.nextToken());
				room[i][j] = area;
			}
		}
		
		result = 0;
		bfs(sX, sY, sDir);
		
		System.out.println(result);
		
	}
	
	public static void bfs(int x, int y, int dir) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] { x, y, dir });
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curDir = cur[2];
			
			if(room[curX][curY] == 0) {
				room[curX][curY] = 2;
				result++;
			}
			
			boolean isCleaned = false;
			int originDir = curDir;
			for(int i = 0; i < 4; i++) {
				int nextDir = (curDir + 4 - 1) % 4;
				int nx = curX + direction[nextDir][0];
				int ny = curY + direction[nextDir][1];
				curDir = (curDir + 4 - 1) % 4;
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				
				if(room[nx][ny] != 0) {
					continue;
				}
				
				q.offer(new int[] { nx, ny, nextDir });
				isCleaned = true;
				break;
			}
			
			if(!isCleaned) {
				int previousDir = (originDir + 4 - 2) % 4;
				int pX = curX + direction[previousDir][0];
				int pY = curY+ direction[previousDir][1];
				
				if(pX < 0 || pY < 0 || pX >= n || pY >= m) {
					continue;
				}
				
				if(room[pX][pY] == 1) {
					continue;
				}
				
				q.offer(new int[] { pX, pY, curDir });
			}
		}
			
	}

}
