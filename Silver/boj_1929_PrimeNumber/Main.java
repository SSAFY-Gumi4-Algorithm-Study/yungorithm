import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		boolean[] isPrime = new boolean[n + 1];
		isPrime[0] = true;
		isPrime[1] = true;
		
		for(int i = 2; i * i <= n; i++) {
			if(!isPrime[i]) {
				for(int j = i * i; j <= n; j += i) {
					isPrime[j] = true;
				}
			}
		}
		
		for(int i = m; i <= n; i++) {
			if(!isPrime[i]) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}

}
