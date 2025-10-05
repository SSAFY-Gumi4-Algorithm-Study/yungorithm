import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] time, pay, dp;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		n = Integer.parseInt(br.readLine());
		
		time = new int[n + 1];
		pay = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n + 2];
		for(int i = n; i > 0; i--) {
			int next = i + time[i];
			
			if(next <= n + 1) {
				dp[i] = Math.max(dp[i + 1], pay[i] + dp[next]);
			} else {
				dp[i] = dp[i + 1];
			}
		}

		System.out.println(dp[1]);
		
	}

}
