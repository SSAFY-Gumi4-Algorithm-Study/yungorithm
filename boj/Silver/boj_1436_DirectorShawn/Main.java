import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int i = 1;
		int num = 666;
		
		while(true) {
			if(Integer.toString(num).contains("666")) {
				if(i == N) {
					break;
				}
				i++;
			}
			num++;
		}
		
		System.out.println(num);
		
	}
	
}
