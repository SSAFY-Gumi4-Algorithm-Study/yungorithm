import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] map, dp;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int max = 0;
				for(int k = 0; k <= i; k++) {
					for(int l = 0; l <= j; l++) {
						if(map[k][l] < map[i][j]) {
							max = Math.max(max, dp[k][l]);
						}
					}
				}
				
				dp[i][j] = max + 1;
				result = Math.max(result, dp[i][j]);
			}
		}
		
		System.out.println(result);

	}

}
