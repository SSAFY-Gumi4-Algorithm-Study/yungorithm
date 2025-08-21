import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static List<Integer>[] list;
	static int[] inDegree;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new List[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		inDegree = new int[n + 1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int before = Integer.parseInt(st.nextToken());
			for(int j = 1; j < k; j++) {
				int after = Integer.parseInt(st.nextToken());
				list[before].add(after);
				inDegree[after]++;
				
				before = after;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		int idx;
		while(!q.isEmpty()) {
			idx = q.poll();
			result.add(idx);
			
			for(int i : list[idx]) {
				inDegree[i]--;
				
				if(inDegree[i] == 0) {
					q.offer(i);
				}
			}
		}
		
		for(int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}
		
		if(result.size() != n) {
			System.out.println(0);
		} else {
			System.out.println(sb);
		}
		
	}

}
