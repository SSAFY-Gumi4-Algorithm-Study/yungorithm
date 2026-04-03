import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		sb.append("<");
		
		int idx = 1;
		while(q.size() > 1) {
			int num = q.poll();
			if(idx % k == 0) {
				sb.append(num).append(", ");
				idx++;
				continue;
			}
			
			q.offer(num);
			idx++;
		}
		
		sb.append(q.poll()).append(">");
		System.out.println(sb);
		
	}

}
