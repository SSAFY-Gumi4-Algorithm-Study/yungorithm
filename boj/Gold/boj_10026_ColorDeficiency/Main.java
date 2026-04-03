import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static int n;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		int[][] colorNormal = new int[n][n];
		int[][] colorDeficiency = new int[n][n];
		for(int i = 0; i < n; i++) {
			char[] str = br.readLine().toCharArray();
			for(int j = 0; j < n; j++) {
				if(str[j] == 'R') {
					colorNormal[i][j] = 1;
					colorDeficiency[i][j] = 1;
				} else if(str[j] == 'G') {
					colorNormal[i][j] = 2;
					colorDeficiency[i][j] = 1;
				} else {
					colorNormal[i][j] = 3;
					colorDeficiency[i][j] = 2;
				}
			}
		}
		
		int cntNormal = 0;
		visited = new boolean[n][n];
		for(int i = 1; i <= 3; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(colorNormal[j][k] == i && !visited[j][k]) {
						bfs(j, k, i, colorNormal);
						cntNormal++;
					}					
				}
			}
		}
		
		int cntDeficiency = 0;
		visited = new boolean[n][n];
		for(int i = 1; i <= 2; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(colorDeficiency[j][k] == i && !visited[j][k]) {
						bfs(j, k, i, colorDeficiency);
						cntDeficiency++;
					}					
				}
			}
		}
		
		sb.append(cntNormal).append(" ").append(cntDeficiency);
		System.out.println(sb);

	}
	
	public static void bfs(int x, int y, int target, int[][] input) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int currX = curr[0];
			int currY = curr[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = currX + dx[i];
				int ny = currY + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				
				if(!visited[nx][ny] && input[nx][ny] == target) {
					 q.offer(new int[] { nx, ny });
					 visited[nx][ny] = true;
				}
			}
		}
	}

}
