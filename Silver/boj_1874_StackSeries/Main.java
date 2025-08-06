import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] stack = new int[N + 1];
		Stack<Integer> st = new Stack<>();
		
		for(int i = 1; i <= N; i++) {
			stack[i] = Integer.parseInt(br.readLine());
		}
		
		int j;
		int max = 0;
		for(int i = 1; i <= N; i++) {
			int num = stack[i];
			
			if(i == 1) {
				for(j = 1; j <= num; j++) {
					st.push(j);
					sb.append("+\n");
				}
				st.pop();
				sb.append("-\n");
			} else {
				if(num < stack[i - 1]) {
					if(st.peek() != num) {
						System.out.println("NO");
						return;
					} else {
						st.pop();
						sb.append("-\n");
					}
				} else {
					for(int k = max + 1; k <= num; k++) {
						st.push(k);
						sb.append("+\n");
					}
					st.pop();
					sb.append("-\n");
				}
			}
			if(max < num) {
				max = num;
			}
		}
		
		System.out.println(sb);
		
	}

}
