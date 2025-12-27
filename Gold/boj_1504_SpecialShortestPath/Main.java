import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge {
		int to;
		int w;
		
		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}
	
	static class Node implements Comparable<Node> {
		int v;
		int dist;
		
		public Node(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}
		
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	static int n, e;
	static ArrayList<Edge>[] graph;
	static final int INF = 1_000_000_000;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int[] dist1 = dijkstra(1);
		int[] distV1 = dijkstra(v1);
		int[] distV2 = dijkstra(v2);
		
		long path1 = (long)dist1[v1] + distV1[v2] + distV2[n];
		long path2 = (long)dist1[v2] + distV2[v1] + distV1[n];
		
		long result = Math.min(path1, path2);
		
		if(dist1[v1] >= INF || distV1[v2] >= INF || distV2[n] >= INF) path1 = Long.MAX_VALUE;
		if(dist1[v2] >= INF || distV2[v1] >= INF || distV1[n] >= INF) path2 = Long.MAX_VALUE;
		
		result = Math.min(path1, path2);
		
		System.out.println(result == Long.MAX_VALUE ? -1 : result);
		
	}
	
	public static int[] dijkstra(int start) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int v = cur.v;
			int d = cur.dist;
			
			if(d != dist[v]) continue;
			
			for(Edge edge : graph[v]) {
				int nv = edge.to;
				int nd = d + edge.w;
				
				if(nd < dist[nv]) {
					dist[nv] = nd;
					pq.offer(new Node(nv, nd));
				}
			}
		}
		
		return dist;
	}
	
}
