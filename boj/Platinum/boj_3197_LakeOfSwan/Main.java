import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int r, c;
	static char[][] lake;
	static int[][] swan;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static Deque<int[]> waterQ, swanQ, nextWaterQ, nextSwanQ;
	static int days;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		lake = new char[r][c];
		swan = new int[2][2];
		waterQ = new ArrayDeque<>();
		nextWaterQ = new ArrayDeque<>();
		swanQ = new ArrayDeque<>();
		nextSwanQ = new ArrayDeque<>();
		visited = new boolean[r][c];
		
		int cntSwan = 0;
		for(int i = 0; i < r; i++) {
			char[] str = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				lake[i][j] = str[j];
				if(lake[i][j] == 'L') {
					if(cntSwan == 0) {
						swan[0][0] = i;
						swan[0][1] = j;
						swanQ.offer(new int[] { i, j });
						visited[i][j] = true;
						cntSwan++;
					} else {
						swan[1][0] = i;
						swan[1][1] = j;
					}
				}
				
				if(lake[i][j] != 'X') {
					waterQ.offer(new int[] { i, j });
				}
			}
		}
		
		days = 0;
		while(true) {
			if(bfsSwan()) {
				sb.append(days);
				break;
			}
			bfs();
			days++;
		}
		
		System.out.println(sb);
		
	}
	
	public static void bfs() {		
		while(!waterQ.isEmpty()) {
			int[] cur = waterQ.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
					continue;
				}
				
				if(lake[nx][ny] == 'X') {
					lake[nx][ny] = '.';
					nextWaterQ.offer(new int[] { nx, ny });
				}
			}
		}
		
		waterQ = nextWaterQ;
		nextWaterQ = new ArrayDeque<>();
	}

	public static boolean bfsSwan() {
		while(!swanQ.isEmpty()) {
			int[] cur = swanQ.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			if(curX == swan[1][0] && curY == swan[1][1]) {
				return true;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
					continue;
				}
				
				if(visited[nx][ny]) {
					continue;
				}
				
				visited[nx][ny] = true;
				if(lake[nx][ny] == 'X') {
					nextSwanQ.offer(new int[] { nx, ny });
				} else {
					swanQ.offer(new int[] { nx, ny });
				}
			}
		}
		
		swanQ = nextSwanQ;
		nextSwanQ = new ArrayDeque<>();
		return false;
	}
	
}
