import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			
			arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(area()).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static long area() {
		Stack<Integer> st = new Stack<>();
		
		long max = 0;
		for(int i = 0; i < n; i++) {
			int now = arr[i];
			
			while(!st.isEmpty() && arr[st.peek()] >= now) {
				int top = st.pop();
				
				long width = st.isEmpty() ? i : i - 1 - st.peek();
				max = Math.max(max, arr[top] * width);
			}
			
			st.push(i);
		}
		
		while(!st.isEmpty()) {
			int top = st.pop();
			long width = st.isEmpty() ? n : n - 1 - st.peek();
			max = Math.max(max, arr[top] * width);
		}
		
		return max;
	}

}
