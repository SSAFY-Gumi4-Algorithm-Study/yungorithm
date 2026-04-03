import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static boolean check[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int min = 1666;
		
		if(N == 4 || N == 7) {
			System.out.println(-1);
		} else {
			for(int i = 0; i <= 1000; i++) {
				for(int j = 0; j <= 1000; j++) {
					int result = 5 * i + 3 * j;
					if(result == N) {
						if(i + j < min) {
							min = i + j;
						}
					}
				}
			}
			
			System.out.println(min);
		}
		
	}

}
