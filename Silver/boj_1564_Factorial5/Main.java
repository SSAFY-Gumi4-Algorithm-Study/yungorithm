import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		long result = 1L;
		long mod = 1_000_000_000_000L;
		
		for(int i = 2; i <= n; i++) {
			result *= i;
			while(result % 10 == 0) {
				result /= 10;
			}
			
			result %= mod;
		}
		
		long answer = result % 100000;
		System.out.printf("%05d", answer);
		
	}
	
}
