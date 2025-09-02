import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Vertex implements Comparable<Vertex> {
		int x;
		int y;
		int money;
		
		public Vertex(int x, int y, int money) {
			this.x = x;
			this.y = y;
			this.money = money;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.money, o.money);
		}
	}
	
	static int n, INF = Integer.MAX_VALUE;
	static int[][] cave;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int idx = 1;
		
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) {
				break;
			}
			
			sb.append("Problem ").append(idx++).append(": ");
			
			cave = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append(dijkstra(0, 0)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static int dijkstra(int x, int y) {
		int[][] minMoney = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				minMoney[i][j] = INF;
			}
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		minMoney[x][y] = cave[x][y];
		pq.offer(new Vertex(x, y, minMoney[x][y]));
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			int curX = cur.x;
			int curY = cur.y;
			int totalMoney = cur.money;
			
			if(curX == n - 1 && curY == n - 1) {
				return totalMoney;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				
				if(minMoney[nx][ny] <= totalMoney + cave[nx][ny]) {
					continue;
				}
				
				minMoney[nx][ny] = totalMoney + cave[nx][ny];
				pq.offer(new Vertex(nx, ny, minMoney[nx][ny]));
			}
		}
		
		return -1;
	}

}
