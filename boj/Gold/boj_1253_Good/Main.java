import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, cnt;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		cnt = 0;
		for(int i = 0; i < n; i++) {
			int target = arr[i];
			
			int l = 0;
			int r = n - 1;
			
			if(l == i) {
				l++;
			}
			if(r == i) {
				r--;
			}
			
			while(l < r) {
				int value = arr[l] + arr[r];
				
				if(l == i) {
					l++;
					continue;
				}
				if(r == i) {
					r--;
					continue;
				}
				
				if(value == target) {
					cnt++;
					break;
				} else if(value < target) {
					l++;
				} else {
					r--;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
}
