import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static boolean[] left, right, vertical;
	static int result;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		left = new boolean[2 * n];
		right = new boolean[2 * n];
		vertical = new boolean[n + 1];
		
		chess(0);
		System.out.println(result);
		
	}
	
	public static void chess(int cnt) {
		if(cnt == n) {
			result++;
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(left[cnt + n - i] || right[i + cnt - 1] || vertical[i]) {
				continue;
			}
			
			left[cnt + n - i] = true;
			right[i + cnt - 1] = true;
			vertical[i] = true;
			
			chess(cnt+1);
			
			left[cnt + n - i] = false;
			right[i + cnt - 1] = false;
			vertical[i] = false;
		}
	}
	
}
