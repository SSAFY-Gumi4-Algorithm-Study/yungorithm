import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Monkey {
		int jumpCnt;
		int x;
		int y;
		
		public Monkey(int jumpCnt, int x, int y) {
			this.jumpCnt = jumpCnt;
			this.x = x;
			this.y = y;
		}
	}
	
	static int k, w, h;
	static int[][] board;
	static int[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] hx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] hy = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		board = new int[h][w];
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new int[k + 1][h][w];
		System.out.println(bfs());
		
	}
	
	public static int bfs() {
		ArrayDeque<Monkey> q = new ArrayDeque<>();
		
		q.offer(new Monkey(0, 0, 0));
		visited[0][0][0] = 0;
		
		while(!q.isEmpty()) {
			Monkey cur = q.poll();
			
			int jumpCnt = cur.jumpCnt;
			int curX = cur.x;
			int curY = cur.y;
			
			if(curX == h - 1 && curY == w - 1) {
				return visited[jumpCnt][curX][curY];
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
					continue;
				}
				
				if(board[nx][ny] == 1 || visited[jumpCnt][nx][ny] != 0) {
					continue;
				}
				
				if(nx == 0 && ny == 0 && jumpCnt == 0) {
					continue;
				}
				
				visited[jumpCnt][nx][ny] = visited[jumpCnt][curX][curY] + 1;
				q.offer(new Monkey(jumpCnt, nx, ny));
			}
			
			if(jumpCnt < k) {
				for(int i = 0; i < 8; i++) {
					int nx = curX + hx[i];
					int ny = curY + hy[i];
					
					if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
						continue;
					}
					
					if(board[nx][ny] == 1 || visited[jumpCnt + 1][nx][ny] != 0) {
						continue;
					}
					
					visited[jumpCnt + 1][nx][ny] = visited[jumpCnt][curX][curY] + 1;
					q.offer(new Monkey(jumpCnt + 1, nx, ny));
				}
			}
		}
		
		return -1;
	}

}
