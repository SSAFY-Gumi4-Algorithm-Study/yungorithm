import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] sanggeun = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			sanggeun[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sanggeun);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			sb.append((upperBound(sanggeun, target) - lowerBound(sanggeun, target))).append(" ");
		}
		
		System.out.println(sb);
		
	}
	
	public static int lowerBound(int[] arr, int target) {
		int start = 0;
		int end = arr.length;
		int m;
		
		while(start < end) {
			m = (start + end) / 2;
			if(arr[m] < target) {
				start = m + 1;
			} else {
				end = m;
			}
		}
		
		return end;
	}
	
	public static int upperBound(int[] arr, int target) {
		int start = 0;
		int end = arr.length;
		int m;
		
		while(start < end) {
			m = (start + end) / 2;
			if(arr[m] <= target) {
				start = m + 1;
			} else {
				end = m;
			}
		}
		
		return end;
	}

}
