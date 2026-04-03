package boj_1012_OrganicCabbage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	static int N;
	static boolean[][] visited;
	static int[][] field;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			field = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				field[y][x] = 1;
			}
			
			int count = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(field[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
		}
		
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0 <= ny && ny < N && 0 <= nx && nx < M) {
				if(field[ny][nx] == 1 && !visited[ny][nx]) {
					dfs(ny, nx);
				}
			}
		}
	}
	
}
