import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static ArrayList<Integer>[] list;
	static int[] parent, depth;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		parent = new int[n + 1];
		depth = new int[n + 1];
		visited = new boolean[n + 1];
		dfs(1, 0);
		
		m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			sb.append(lca(from, to)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int node, int d) {
		visited[node] = true;
		depth[node] = d;
		
		for(int next : list[node]) {
			if(visited[next]) continue;
			
			parent[next] = node;
			dfs(next, d + 1);
		}
	}
	
	public static int lca(int from, int to) {
		if(depth[from] < depth[to]) {
			int tmp = from;
			from = to;
			to = tmp;
		}
		
		while(depth[from] != depth[to]) {
			from = parent[from];
		}
		
		while(from != to) {
			from = parent[from];
			to = parent[to];
		}
		
		return from;
	}
	
}
