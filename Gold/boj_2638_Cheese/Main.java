import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] map;
	static boolean[][] out;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		int cheese = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheese++;
			}
		}

		int result = 0;
		while(cheese > 0) {
			bfsEmpty();
			int melted = melt();
			cheese -= melted;
			result++;
		}

		System.out.println(result);
		
	}

	public static void bfsEmpty() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		out = new boolean[n][m];

		q.offer(new int[] { 0, 0 });
		out[0][0] = true;

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

				if(out[nx][ny] || map[nx][ny] == 1) continue;

				q.offer(new int[] { nx, ny });
				out[nx][ny] = true;
			}
		}
	}

	public static int melt() {
		ArrayDeque<int[]> q = new ArrayDeque<>();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] != 1) continue;

				int touch = 0;
				for(int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
					if(out[nx][ny]) touch++;
				}

				if(touch >= 2) q.offer(new int[] { i, j });
			}
		}

		int melted = q.size();
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			map[cur[0]][cur[1]] = 0;
		}

		return melted;
	}
	
}
