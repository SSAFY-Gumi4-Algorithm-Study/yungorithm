import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long[] trees = new long[n];
		long max = 0;
		
		for(int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		long result = upperBound(trees, k, max) - 1;
		sb.append(result);
		
		System.out.println(sb);
		
	}
	
	public static long upperBound(long[] input, long k, long maxHeight) {
		long start = 0;
		long end = maxHeight + 1;
		
		while(start < end) {
			long mid = (start + end) / 2;
			long cnt = 0;
			
			for(long tree : input) {
				if(tree > mid) {
					cnt += tree - mid;
				}
			}
			
			if(cnt < k) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return end;
	}

}
