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
		
		int[] days = new int[366];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			for(int j = s; j <= e; j++) {
				days[j] += 1;
			}
		}
		
		int start = 1;
		int max = 0;
		int result = 0;
		for(int i = 1; i < 366; i++) {
			if(days[i] > 0) {
				max = Math.max(max, days[i]);
			} else {
				result += (i - start) * max;
				max = 0;
				start = i + 1;
			}
		}
		
		if(max > 0) result += (365 - start + 1) * max;
		
		System.out.println(result);
		
	}
	
}
