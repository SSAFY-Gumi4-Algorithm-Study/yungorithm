import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1 ,1 };
	static int cnt;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < n; j++) {
				map[i][j] = ch[j] - '0';
			}
		}
		
		list = new ArrayList<>();
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] || map[i][j] == 0) {
					continue;
				}
				cnt = 0;
				++cnt;
				bfs(i, j);
			}
		}
		
		Collections.sort(list);
		
		sb.append(list.size()).append("\n");
		for(int i : list) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static void bfs(int x, int y) {
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
				
				if(visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}
				
				++cnt;
				q.offer(new int[] { nx, ny });
				visited[nx][ny] = true;
			}
		}
		list.add(cnt);
		
	}

}
