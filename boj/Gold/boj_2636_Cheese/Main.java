import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int days, tmp;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cheese = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		days = 0;
		while(true) {
			int remain = countCheese();
			if(remain == 0) {
				break;
			}
			
			tmp = remain;
			bfs();
			days++;
		}
		
		sb.append(days).append("\n").append(tmp);
		System.out.println(sb);
		
	}
	
	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		visited = new boolean[n][m];
		
		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int currX = curr[0];
			int currY = curr[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = currX + dx[i];
				int ny = currY + dy[i];
				
				if(nx < 0 || ny < 0|| nx >= n || ny >= m) {
					continue;
				}
				
				if(visited[nx][ny]) {
					continue;
				}
				
				visited[nx][ny] = true;
				
				if(cheese[nx][ny] == 1) {
					cheese[nx][ny] = 0;
				} else {
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}
	
	public static int countCheese() {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(cheese[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}

}
