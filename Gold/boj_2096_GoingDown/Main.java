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
		
		int[][] arr = new int[n][3];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] maxDp = new int[n][3];
		int[][] minDp = new int[n][3];
		
		for(int i = 0; i < 3; i++) {
			maxDp[0][i] = arr[0][i];
			minDp[0][i] = arr[0][i];
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				int maxSum = 0;
				int minSum = 900001;
				int maxPost = arr[i][j];
				int minPost = arr[i][j];
				for(int k = 0; k < 3; k++) {
					if(Math.abs(j - k) <= 1) {
						maxSum = Math.max(maxSum, maxDp[i - 1][k] + maxPost);
						minSum = Math.min(minSum, minDp[i - 1][k] + minPost);
					}
				}
				
				maxDp[i][j] = maxSum;
				minDp[i][j] = minSum;
			}
		}
		
		int max = 0;
		int min = 900001;
		
		for(int i = 0; i < 3; i++) {
			if(max < maxDp[n - 1][i]) max = maxDp[n - 1][i];
			if(min > minDp[n - 1][i]) min = minDp[n - 1][i];
		}
		
		sb.append(max).append(' ').append(min);
		System.out.println(sb);
		
	}
	
}
