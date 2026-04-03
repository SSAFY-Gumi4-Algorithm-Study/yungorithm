import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] h = new int[n + 1];
        int[] cnt = new int[n + 1];
        int[] nearest = new int[n + 1];
        Stack<Integer> stack;
        
        st = new StringTokenizer(br.readLine());
        for(int i =1 ; i <= n; i++){
            h[i] = Integer.parseInt(st.nextToken());
            nearest[i] = -100000;
        }

        stack = new Stack<>();
        for(int i = 1; i <= n; i++){
            while(!stack.isEmpty() && h[stack.peek()] <= h[i]) {
                stack.pop();
            }
            cnt[i] = stack.size();
            if(cnt[i] > 0) {
            	nearest[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for(int i = n; i > 0; i--){
            while(!stack.isEmpty() && h[stack.peek()] <= h[i]) {
                stack.pop();
            }
            int s = stack.size();
            cnt[i] += s;
            if(s > 0 && stack.peek() - i < i - nearest[i]) {
            	nearest[i] = stack.peek();
            
            }
            stack.push(i);
        }
		
		for(int i = 1; i <= n; i++) {
			sb.append(cnt[i]);
			if(cnt[i] > 0) {
				sb.append(" ").append(nearest[i]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

}
