import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
			case "push":
				int x = Integer.parseInt(st.nextToken());
				dq.push(x);
				break;
			case "pop":
				sb.append(dq.isEmpty() ? -1 : dq.pop()).append("\n");
				break;
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
				sb.append(dq.isEmpty() ? 1 : 0).append("\n");
				break;
			case "top":

				sb.append(dq.isEmpty() ? -1 : dq.peek()).append("\n");
				break;
			}

		}
		
		System.out.println(sb);
		
	}

}
