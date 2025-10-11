import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] map;
	static int sx, sy;
	static int size = 2, eat = 0;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
					continue;
				}
				map[i][j] = num;
			}
		}
		
		int result = 0;
		while(true) {
			int[] fish = bfs();
			if(fish == null) {
				break;
			}
			
			int fishX = fish[0];
			int fishY = fish[1];
			int dist = fish[2];
			result += dist;
			sx = fishX;
			sy = fishY;
			map[fishX][fishY] = 0;
			
			eat++;
			if(eat == size) {
				size++;
				eat = 0;
			}
		}
		
		System.out.println(result);
		
	}
	
	public static int[] bfs() {
		int[][] dist = new int[n][n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(dist[i], -1);
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] { sx, sy });
		dist[sx][sy] = 0;
		
		int targetX = -1;
		int targetY = -1;
		int shortest = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			if(dist[curX][curY] > shortest) {
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				
				if(dist[nx][ny] != -1 || map[nx][ny] > size) {
					continue;
				}
				
				dist[nx][ny] = dist[curX][curY] + 1;
				
				if(map[nx][ny] > 0 && map[nx][ny] < size) {
					if(dist[nx][ny] < shortest) {
						shortest = dist[nx][ny];
						targetX = nx;
						targetY = ny;
					} else if(dist[nx][ny] == shortest) {
						if(nx < targetX || (nx == targetX && ny < targetY)) {
							targetX = nx;
							targetY = ny;
						}
					}
				}
				
				q.offer(new int[] { nx, ny });
			}
		}
		
		if(targetX == -1) {
			return null;
		}
		
		return new int[] { targetX, targetY, shortest };
	}
	
}
