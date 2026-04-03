import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static int n, max, root;
	static ArrayList<Node>[] list;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}
		
		max = 0;
		root = 1;
		dist = new int[n + 1];
		visited = new boolean[n + 1];
		dfs(1);
		
		int idx = 0;
		for(int i = 1; i <= n; i++) {
			if(max == dist[i]) {
				idx = i;
				break;
			}
		}
		
		root = idx;
		dist = new int[n + 1];
		visited = new boolean[n + 1];
		dfs(idx);
		
		int result = 0;
		for(int i = 1; i <= n; i++) {
			if(result < dist[i]) result = dist[i];
		}
		
		System.out.println(result);

	}
	
	public static void dfs(int node) {
		if(visited[node]) return;
		
		visited[node] = true;
		
		for(Node n : list[node]) {
			if(dist[n.to] != 0 || n.to == root) continue;
			
			dist[n.to] = dist[node] + n.cost;
			max = Math.max(max, dist[n.to]);
			dfs(n.to);
		}
	}

}
