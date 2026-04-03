import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				list.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}
			
			int cnt = 0;
			while(!list.isEmpty()) {
				int front[] = list.poll();
				boolean isMax = true;
				
				for(int i = 0; i < list.size(); i++) {
					if(front[1] < list.get(i)[1]) {
						list.offer(front);
						
						for(int j = 0; j < i; j++) {
							list.offer(list.poll());
						}
						
						isMax = false;
						break;
					}
				}

				if(!isMax) {
					continue;
				}
				
				cnt++;
				if(front[0] == m) {
					break;
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
