import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int result = 1;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		combination(n, m);
		
		System.out.println(result);
		
	}
	
	public static void combination(int a, int b) {
		if(b == 0) {
			return;
		}
		
		int molecular = 1;
		int denominator = 1;
		for(int i = 0; i < b; i++) {
			molecular *= (a - i);
			denominator *= (b - i);
		}
		
		result = molecular / denominator;
		
		return;
		
	}

}
