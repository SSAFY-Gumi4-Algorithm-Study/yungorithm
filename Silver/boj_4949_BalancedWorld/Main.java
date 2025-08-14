import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		outer:
		while(true) {			
			String str = br.readLine();
			if(str.equals(".")) {
				break;
			}
			
			Stack<Character> stack = new Stack<Character>();
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if(c == '(' || c == '[') {
					stack.push(c);
				} else if(c == ')') {
					if(stack.empty() || stack.peek() != '(') {
						sb.append("no\n");
						continue outer;
					} else {
						stack.pop();
					}
				} else if(c == ']') {
					if(stack.empty() || stack.peek() != '[') {
						sb.append("no\n");
						continue outer;
					} else {
						stack.pop();
					}
				}
			}
			
			if(stack.isEmpty()) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
			
		}
		
		System.out.println(sb);
		
	}

}
