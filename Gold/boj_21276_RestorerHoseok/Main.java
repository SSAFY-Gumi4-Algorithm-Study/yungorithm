import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static HashMap<String, ArrayList<String>> relation = new HashMap<>();
	static HashMap<String, PriorityQueue<String>> direct = new HashMap<>();
	static HashMap<String, Integer> indegree = new HashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		String[] names = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			String name = names[i];
			relation.put(name, new ArrayList<>());
			direct.put(name, new PriorityQueue<>());
			indegree.put(name, 0);
		}
		
		m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String son = st.nextToken();
			String parent = st.nextToken();
			
			relation.get(parent).add(son);
			indegree.put(son, indegree.get(son) + 1);
		}
		
		int k = 0;
		ArrayDeque<String> q = new ArrayDeque<>();
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		for(String name : indegree.keySet()) {
			if(indegree.get(name) == 0) {
				k++;
				q.offer(name);
				pq.offer(name);
			}
		}
		
		sb.append(k).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append(' ');
		}
		sb.append("\n");
		
		while(!q.isEmpty()) {
			String parent = q.poll();
			ArrayList<String> children = relation.get(parent);
			for(String child : children) {
				int p = indegree.get(child);
				
				if(p == 1) {
					direct.get(parent).add(child);
					q.offer(child);
				}
				
				indegree.put(child, p - 1);
			}
		}
		
		for(String parent : direct.keySet()) {
			PriorityQueue<String> children = direct.get(parent);
			StringBuilder result = new StringBuilder();
			result.append(parent).append(' ').append(children.size()).append(' ');
			while(!children.isEmpty()) {
				result.append(children.poll()).append(' ');
			}
			result.append("\n");
			
			pq.offer(result.toString());
		}
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll());
		}
		
		System.out.println(sb);
		
	}

}
