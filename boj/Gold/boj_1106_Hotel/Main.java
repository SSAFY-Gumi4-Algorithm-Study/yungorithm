import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] cost = new int[n];
		int[] person = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxPerson = 0;
		for(int p : person) {
			maxPerson = Math.max(maxPerson, p);
		}
		
		int limit = c + maxPerson;
		int INF = 1_000_000_000;
		
		int[] dp = new int[limit + 1];
		Arrays.fill(dp, INF);
		
		dp[0] = 0;
		
		for(int i = 0; i <= limit; i++) {
			if(dp[i] == INF) continue;
			for(int j = 0; j < n; j++) {
				int ni = i + person[j];
				
				if(ni > limit) continue;
				
				dp[ni] = Math.min(dp[ni], dp[i] + cost[j]);
			}
		}
		
		int result = INF;
		for(int i = c; i <= limit; i++) {
			result = Math.min(result, dp[i]);
		}
		
		System.out.println(result);
		
	}
	
}
