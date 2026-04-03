import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static String[][] map;
	static String result = "NO";
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new String[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = st.nextToken();
			}
		}
		
		dfs(0);
		
		System.out.println(result);
		
	}
	
	public static void dfs(int depth) {
		if(depth == 3) {
			check();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j].equals("X")) {
					map[i][j] = "O";
					dfs(depth + 1);
					map[i][j] = "X";
				}
			}
		}
	}
	
	public static void check() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j].equals("T")) {
					for(int d = 0; d < 4; d++) {
						if(!move(i, j, d)) {
							return;
						}
					}
				}
			}
		}
		
		result = "YES";
	}

	public static boolean move(int x, int y, int dir) {
		while(x >= 0 && y >= 0 && x < n && y < n && !map[x][y].equals("O")) {
			if(map[x][y].equals("S")) {
				return false;
			}
			
			x += dx[dir];
			y += dy[dir];
		}
		
		return true;
	}
	
}
