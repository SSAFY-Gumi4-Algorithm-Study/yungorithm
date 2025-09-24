import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static int n, m, x, INF = Integer.MAX_VALUE / 4;
	static ArrayList<Node>[] list;
	static int[] minCost, result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, cost));
		}
		
		result = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			dijkstra(i);
			if(i == x) {
				for(int j = 1; j <= n; j++) {
					result[j] += minCost[j];
				}
			} else {
				result[i] += minCost[x];				
			}
		}
		
		int max = 0;
		for(int i = 1; i <= n; i++) {
			if(max < result[i]) {
				max = result[i];
			}
		}
		
		System.out.println(max);
		
	}
	
	public static void dijkstra(int start) {
		minCost = new int[n + 1];
		Arrays.fill(minCost, INF);
		
		minCost[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, minCost[start]));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int from = cur.to;
			int cost = cur.cost;
			
			if(cost > minCost[from]) {
				continue;
			}
			
			for(Node next : list[from]) {
				if(minCost[next.to] < cost + next.cost) {
					continue;
				}
				
				minCost[next.to] = cost + next.cost;
				pq.offer(new Node(next.to, minCost[next.to]));
			}
		}
	}
	
}
