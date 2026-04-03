import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		outer: while (n-- != 0) {
			String str = br.readLine();

			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.empty() || stack.peek() != '(') {
						sb.append("NO\n");
						continue outer;
					} else {
						stack.pop();
					}
				} else if (c == ']') {
					if (stack.empty() || stack.peek() != '[') {
						sb.append("NO\n");
						continue outer;
					} else {
						stack.pop();
					}
				}
			}

			if (stack.isEmpty()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}

		}

		System.out.println(sb);

	}

}
