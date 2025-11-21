import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int x;
		int y;
		int canBreak;
		
		public Node(int x, int y, int canBreak) {
			this.x = x;
			this.y = y;
			this.canBreak = canBreak;
		}
	}
	
	static int n, m, t;
	static int[][] map;
	static int[][][] dist;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());;
		
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dist = new int[2][n][m];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < n; j++) {
				Arrays.fill(dist[i][j], -1);
			}
		}
		
		int result = bfs();
		System.out.println((result == -1 || result > t) ? "Fail" : result);
        
    }
    
    public static int bfs() {
    	ArrayDeque<Node> q = new ArrayDeque<>();
    	dist[0][0][0] = 0;
    	
    	q.offer(new Node(0, 0, 0));
    	
    	while(!q.isEmpty()) {
    		Node cur = q.poll();
    		int d = dist[cur.canBreak][cur.x][cur.y];
    		
    		if(cur.x == n - 1 && cur.y == m - 1) return d;
    		
    		for(int i = 0; i < 4; i++) {
    			int nx = cur.x + dx[i];
    			int ny = cur.y + dy[i];
    			
    			if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
    			
    			int canBreak = cur.canBreak;
    			
    			if(map[nx][ny] == 1) {
    				if(canBreak == 0) continue;
    			} else if(map[nx][ny] == 2) {
    				canBreak = 1;
    			}
    			
    			if(dist[canBreak][nx][ny] != -1) continue;
    			
    			dist[canBreak][nx][ny] = d + 1;
    			q.offer(new Node(nx, ny, canBreak));
    		}
    	}
    	
    	return -1;
    }
    
}
