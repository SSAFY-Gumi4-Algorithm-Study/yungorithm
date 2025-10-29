import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[2];
		
		int l = 0;
		int r = n - 1;
		int sum = Integer.MIN_VALUE + 1;
		
		while(l < r) {
			int diff = arr[l] + arr[r];
			
			if(diff > 0) {
				if(diff < Math.abs(sum)) {
					sum = diff;
					result[0] = arr[l];
					result[1] = arr[r];
				}
				r--;
			} else if(diff < 0) {
				if(Math.abs(diff) < Math.abs(sum)) {
					sum = diff;
					result[0] = arr[l];
					result[1] = arr[r];
				}
				l++;
			} else {
				System.out.println(arr[l] + " " + arr[r]);
				return;
			}
		}
		
		System.out.println(result[0] + " " + result[1]);
		
	}
	
}
