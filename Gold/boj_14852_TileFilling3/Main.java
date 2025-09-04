import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static long MOD = 1_000_000_007L;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n + 1];
		long[] sum = new long[n + 1];
		
		dp[0] = 1;
		dp[1] = 2;
		
		sum[0] = dp[0];
		sum[1] = dp[0] + dp[1];
		
		
		if(n >= 2) {
			for(int i = 2; i <= n; i++) {
				long a = 2 * (sum[i - 1] % MOD);
				long b = dp[i - 2] % MOD;
				dp[i] = (a + b) % MOD;
				sum[i] = (sum[i - 1] + dp[i]) % MOD;
			}
		}
		
		System.out.println(dp[n]);
		
	}
}
