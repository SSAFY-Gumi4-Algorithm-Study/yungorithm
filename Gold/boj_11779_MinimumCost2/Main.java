import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
	
	static int n, m, INF = Integer.MAX_VALUE / 4;
	static ArrayList<Node>[] list;
	static int[] minCost, prev;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
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
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		sb.append(minCost[end]).append("\n");
		bfs(start, end, prev);
		
		System.out.println(sb);

	}
	
	public static void dijkstra(int start) {
		minCost = new int[n + 1];
		Arrays.fill(minCost, INF);
		prev = new int[n + 1];
		
		minCost[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(start, minCost[start]));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int from  = cur.to;
			int cost = cur.cost;
			
			if(cost > minCost[from]) {
				continue;
			}
			
			for(Node next : list[from]) {
				if(minCost[next.to] <= cost + next.cost) {
					continue;
				}
				
				minCost[next.to] = cost + next.cost;
				prev[next.to] = from;
				pq.offer(new Node(next.to, minCost[next.to]));
			}
		}
	}
	
	public static void bfs(int start, int end, int[] prev) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		int cur = end;
		
		while(cur != 0) {
			q.push(cur);
			
			if(cur == start) {
				break;
			}
			
			cur = prev[cur];
		}
		
		sb.append(q.size()).append("\n");
		
		while(!q.isEmpty()) {
			sb.append(q.pop()).append(" ");
		}
		sb.setLength(sb.length() - 1);
	}

}
