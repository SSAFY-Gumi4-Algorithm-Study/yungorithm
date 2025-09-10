import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n;
	static Point[] p;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			
			p = new Point[n + 2];
			for(int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				p[i] = new Point(x, y);
			}
			
			visited = new boolean[n + 2];
			sb.append(bfs() ? "happy" : "sad").append("\n");
		}
		
		System.out.println(sb);

	}
	
	public static boolean bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		q.offer(0);
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(distance(p[cur], p[n + 1]) <= 1000) {
				return true;
			}
			
			for(int i = 1; i < n + 2; i++) {
				if(visited[i] || distance(p[cur], p[i]) > 1000) {
					continue;
				}
				
				q.offer(i);
				visited[i] = true;
			}
		}
		
		return false;
	}
	
	public static int distance(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y); 
	}

}
