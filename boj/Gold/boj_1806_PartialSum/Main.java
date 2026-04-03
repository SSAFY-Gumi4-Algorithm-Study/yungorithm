import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, s, result;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0;
		int r = 0;
		int sum = arr[l];
		result = Integer.MAX_VALUE;
		
		while(l <= r) {
			if(sum < s) {
				if(r == n - 1) {
					break;
				}
				sum += arr[++r];
			} else {
				result = Math.min(result, r - l + 1);
				sum -= arr[l++];
			}			
		}
		
		System.out.println(result == Integer.MAX_VALUE ? 0 : result);
		
	}

}
