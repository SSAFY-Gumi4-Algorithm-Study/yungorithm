import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[31];

		dp[2] = 3;
		dp[4] = 11;
		
		if(n >= 6 && n % 2 == 0 ) {
			for(int i = 6; i <= n; i += 2) {
				dp[i] = 4 * dp[i - 2] - dp[i - 4];
			}
		}
		System.out.println(n % 2 == 0 ? dp[n] : 0);
		
	}

}
