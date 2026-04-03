import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int to;
		int dist;
		
		public Node(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
	}
	
	static int n, from, to, dist;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int max = 0;
	static int node;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			while(true) {
				to = Integer.parseInt(st.nextToken());
				if(to == -1) {
					break;
				}
				dist = Integer.parseInt(st.nextToken());
				
				list[from].add(new Node(to, dist));
			}
		}
		
		visited = new boolean[n + 1];
		dfs(1, 0);
		
		visited = new boolean[n + 1];
		dfs(node, 0);
		
		System.out.println(max);
		
	}
	
	public static void dfs(int start, int depth) {
		if(max < depth) {
			max = depth;
			node = start;
		}
		
		visited[start] = true;
		
		int size = list[start].size();
		for(int i = 0; i < size; i++) {
			Node next = list[start].get(i);
			if(visited[next.to]) {
				continue;
			}
			
			visited[next.to] = true;
			dfs(next.to, depth + next.dist);
		}
	}
	
}
