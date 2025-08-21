import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static ArrayList<Integer>[] list;
	static int[] inDegree;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n + 1];
		inDegree = new int[n + 1];
		for(int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList();
		}
		
		int from, to;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			inDegree[to]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i < n + 1; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}		
		}
		
		// 큐 사이즈가 0이면 위상정렬 불가능 - 가지치기 가능한 부분
		int idx;
		while(!q.isEmpty()) {	// bfs랑 비슷
			idx = q.poll();
			sb.append(idx).append(" ");
			
			for(int i : list[idx]) {
				inDegree[i]--;
				
				if(inDegree[i] == 0) {
					q.offer(i);
				}
			}
		}
		
		System.out.println(sb);
		
	}

}
