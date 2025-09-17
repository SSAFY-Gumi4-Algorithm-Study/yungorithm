import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Vertex implements Comparable<Vertex> {
		int to;
		long time;
		int parity;
		
		public Vertex(int to, long time) {
			this.to = to;
			this.time = time;
		}
		
		public Vertex(int to, long time, int parity) {
			this.to = to;
			this.time = time;
			this.parity = parity;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.time, o.time);
		}
	}
	
	static int n, m;
	static long INF = Long.MAX_VALUE / 4;
	static ArrayList<Vertex>[] list;
	static long[] minTimeFox;
	static long[][] minTimeWolf;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++ ) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long time = Integer.parseInt(st.nextToken()) * 2L;
			
			list[from].add(new Vertex(to, time));
			list[to].add(new Vertex(from, time));
		}
		
		dijkstraFox();
		dijkstraWolf();
		
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			long fox = minTimeFox[i];
			long wolf = Math.min(minTimeWolf[i][0], minTimeWolf[i][1]);
			
			if(fox < wolf) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}
	
	public static void dijkstraFox() {
		minTimeFox = new long[n + 1];
		Arrays.fill(minTimeFox, INF);
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		minTimeFox[1] = 0;
		pq.offer(new Vertex(1, 0));
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			int curTo = cur.to;
			long curTime = cur.time;
			
			if(curTime != minTimeFox[curTo]) {
				continue;
			}
			
			for(Vertex next : list[curTo]) {
				if(minTimeFox[next.to] <= minTimeFox[curTo] + next.time) {
					continue;
				}
				
				minTimeFox[next.to] = minTimeFox[curTo] + next.time; 
				pq.offer(new Vertex(next.to, minTimeFox[next.to]));
			}
		}
	}
	
	public static void dijkstraWolf() {
		minTimeWolf = new long[n + 1][2];
		for(int i = 0; i <= n; i++) {
			Arrays.fill(minTimeWolf[i], INF);
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		minTimeWolf[1][0] = 0;
		pq.offer(new Vertex(1, 0, 0));
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			int curTo = cur.to;
			long curTime = cur.time;
			int curParity = cur.parity;
			
			if(curTime != minTimeWolf[curTo][curParity]) {
				continue;
			}
			
			for(Vertex next : list[curTo]) {
				long wolfTime = (curParity == 0) ? next.time / 2 : next.time * 2;
				int nextParity = curParity ^ 1;
				
				if(minTimeWolf[next.to][nextParity] <= minTimeWolf[curTo][curParity] + wolfTime) {
					continue;
				}
				
				minTimeWolf[next.to][nextParity] = minTimeWolf[curTo][curParity] + wolfTime;
				pq.offer(new Vertex(next.to, minTimeWolf[next.to][nextParity], nextParity));
			}
		}
	}

}
