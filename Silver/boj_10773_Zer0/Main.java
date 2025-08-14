import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a == 0) {
				stack.pop();
			} else {
				stack.push(a);
			}
		}

		int sum = 0;
		int mx = stack.size();
		for (int i = 0; i < mx; i++) {
			int a = stack.pop();
			sum += a;
		}

		System.out.println(sum);

	}

}
