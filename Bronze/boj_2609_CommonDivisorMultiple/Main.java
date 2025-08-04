import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		for(int i = Math.min(A, B); i > 0; i--) {
			if(A % i == 0 && B % i == 0) {
				System.out.println(i);
				break;
			}
		}
		
		int i = Math.max(A, B);
		while(true) {
			if(i % A == 0 && i % B == 0) {
				System.out.println(i);
				break;
			}
			i++;
		}
		
	}
	
}
