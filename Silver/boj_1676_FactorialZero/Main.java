import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());		
		int cnt = N / 5 + N / 25 + N / 125;
		
		System.out.println(cnt);
		
	}
	
}
