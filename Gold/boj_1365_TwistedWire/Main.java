import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr, dp;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n];
		
		System.out.println(n - lis());

	}
	
	public static int lis() {
		dp[0] = arr[0];
		int idx = 0;
		
		for(int i = 1; i < n; i++) {
			if(dp[idx] < arr[i]) {
				dp[++idx] = arr[i];
			} else {
				int ii = lowerBound(dp, idx, arr[i]);
				dp[ii] = arr[i];
			}
		}
		
		return idx + 1;
	}
	
	public static int lowerBound(int[] input, int end, int n) {
		int start = 0;
		
		while(start < end) {
			int mid = (start + end) / 2;
			if(input[mid] >= n) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return end;
	}

}
