import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Ramen implements Comparable<Ramen> {
		int deadline;
		int ramen;
		
		public Ramen(int deadline, int ramen) {
			this.deadline = deadline;
			this.ramen = ramen;
		}
		
		@Override
		public int compareTo(Ramen o) {
			if(this.deadline == o.deadline) return o.ramen - this.ramen;
			return this.deadline - o.deadline;
		}
	}
	
	static int n;
	static ArrayList<Ramen> list;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.add(new Ramen(a, b));
		}
		
		Collections.sort(list);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(Ramen r : list) {
			pq.offer(r.ramen);
			
			if(pq.size() > r.deadline) {
				pq.poll();
			}
		}
		
		long result = 0;
		while(!pq.isEmpty()) {
			result += pq.poll();
		}
		
		System.out.println(result);

	}

}
