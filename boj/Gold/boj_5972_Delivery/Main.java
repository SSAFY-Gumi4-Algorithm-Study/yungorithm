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
	
	static int n, m, INF = 1_000_000_000;
	static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
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
        	list[to].add(new Node(from, cost));
        }
        
        System.out.println(dijkstra());
        
    }
    
    public static int dijkstra() {
    	int[] minCost = new int[n + 1];
    	Arrays.fill(minCost, INF);
    	minCost[1] = 0;
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	
    	pq.offer(new Node(1, 0));
    	
    	while(!pq.isEmpty()) {
    		Node cur = pq.poll();
    		int to = cur.to;
    		int cost = cur.cost;
    		
    		for(Node next : list[to]) {
    			int nextTo = next.to;
    			int nextCost = cost + next.cost;
    			
    			if(nextCost < minCost[nextTo]) {
    				minCost[nextTo] = nextCost;
    				pq.offer(new Node(nextTo, minCost[nextTo]));
    			}
    		}
    	}
    	
    	return minCost[n];
    }
    
}
