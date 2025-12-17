import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		int aSize = a.length();
		int bSize = b.length();
		
		int[] dp = new int[bSize + 1];
		
		for(int i = 1; i <= aSize; i++) {
			int prev = 0;
			for(int j = 1; j <= bSize; j++) {
				int temp = dp[j];
				
				if(a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[j] = prev + 1;
				} else {
					dp[j] = Math.max(dp[j], dp[j - 1]);
				}
				
				prev = temp;
			}
		}
		
		System.out.println(dp[bSize]);
		
	}
	
}
