import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long negative = Long.MIN_VALUE / 4;
		long[] dp = new long[101];
		Arrays.fill(dp, negative);
		
		long result = 0;
		
		for(int i = 1; i <= n; i++) {
			int x = arr[i];
			long[] prev = dp.clone();
			
			dp[x] = Math.max(dp[x], 0);
			
			for(int v = 1; v <= 100; v++) {
				if(prev[v] == negative) continue;
				
				long can = prev[v] + (long)(x - v) * (x - v);
				if(can > dp[x]) dp[x] = can;
			}
			
			if(dp[x] > result) result = dp[x];
		}
		
		System.out.println(result);
		
	}
	
}
