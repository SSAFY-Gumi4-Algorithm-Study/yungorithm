import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Vertex implements Comparable<Vertex> {
		int to;
		int cost;
		
		public Vertex(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static int v, e, k, INF = 1_000_000;
	static ArrayList<Vertex>[] list;
	static int[] minCost;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		
		list = new ArrayList[v + 1];
		for(int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Vertex(to, cost));
		}
		
		dijkstra(k);
		
		for(int i = 1; i <= v; i++) {
			sb.append(minCost[i] == INF ? "INF" : minCost[i]).append("\n");
		}
		
		System.out.println(sb);

	}
	
	public static void dijkstra(int from) {
		minCost = new int[v + 1];
		
		for(int i = 1; i <= v; i++) {
			minCost[i] = INF;
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		minCost[from] = 0;
		pq.offer(new Vertex(from, minCost[from]));
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			
			// 오래된 정점 스킵
			if(cur.cost > minCost[cur.to]) {
				continue;
			}
			
			for(Vertex next : list[cur.to]) {
				int nextTo = next.to;
				int nextCost = next.cost;
				int totalCost = nextCost + cur.cost;
				
				if(totalCost < minCost[nextTo]) {
					minCost[nextTo] = totalCost;
					pq.offer(new Vertex(nextTo, minCost[nextTo]));
				}
			}
			
		}
	}

}
