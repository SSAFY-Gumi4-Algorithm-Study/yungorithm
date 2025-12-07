import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		map = new int[r + 1][c + 1];
		for(int i = 1; i <= r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= c; j++) {
				map[i][j] = map[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int div = (r2 - r1 + 1) * (c2 - c1 + 1);
			
			sb.append(calc(r1, c1, r2, c2) / div).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static int calc(int sr, int sc, int er, int ec) {
		int sum = 0;
		for(int i = sr; i <= er; i++) {
			sum += map[i][ec];
		}
		
		if(sc != 1) {
			for(int i = sr; i <= er; i++) {
				sum -= map[i][sc - 1];
			}
		}
		
		return sum;
	}
	
}
