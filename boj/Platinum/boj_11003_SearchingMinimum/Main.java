import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int n, l;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
				
		Deque<int[]> dq = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(!dq.isEmpty() && dq.peekLast()[0] > num) {
				dq.pollLast();
			}
			
			dq.offer(new int[] { num, i });
			if(dq.peek()[1] < i - (l - 1)) {
				dq.poll();
			}
			
			sb.append(dq.peek()[0]).append(" ");
		}
		
		System.out.println(sb);
	}
	
}
