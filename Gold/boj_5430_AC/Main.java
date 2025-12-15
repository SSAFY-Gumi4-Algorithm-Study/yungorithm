import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String s = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String nums = br.readLine().trim();
			
			ArrayDeque<Integer> q = new ArrayDeque<>();
			
			if(n > 0) {
				String inner = nums.substring(1, nums.length() - 1);
				st = new StringTokenizer(inner, ",");
				while(st.hasMoreTokens()) {
					q.offer(Integer.parseInt(st.nextToken()));
				}
			}
			
			boolean reversed = false;
			boolean error = false;
			
			for(int i = 0; i < s.length(); i++) {
				char op = s.charAt(i);
				
				if(op == 'R') {
					reversed = !reversed;
				} else {
					if(q.isEmpty()) {
						error = true;
						break;
					}
					
					if(!reversed) q.pollFirst();
					else q.pollLast();
				}
			}
			
			if(error) {
				sb.append("error\n");
				continue;
			}
			
			sb.append('[');
			if(!q.isEmpty()) {
				if(!reversed) {
					while(q.size() > 1) sb.append(q.pollFirst()).append(',');
					sb.append(q.pollFirst());
				} else {
					while(q.size() > 1) sb.append(q.pollLast()).append(',');
					sb.append(q.pollLast());
				}
			}
			
			sb.append(']').append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}
