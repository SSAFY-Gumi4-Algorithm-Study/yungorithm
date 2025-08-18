import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long[] lan = new long[k];
		long max = 0;
		
		for(int i = 0; i < k; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lan[i]);
		}
		
		long result = upperBound(lan, n, max) - 1;
		sb.append(result);
		
		System.out.println(sb.toString());

	}
	
	public static long upperBound(long[] input, int n, long maxLen) {
		long start = 1;
		long end = maxLen + 1;
		
		while(start < end) {
			long mid = (start + end) / 2;
			long cnt = 0;
			
			for(long l: input) {
				cnt += l / mid;
			}
			
			if(cnt < n) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		
		return end;
	}

}
