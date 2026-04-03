import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, k, x;
	static ArrayList<Integer>[] list;
	static int[] minDist;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
		
		dijkstra();
		
		for(int i = 1; i <= n; i++) {
			if(minDist[i] == k) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb.length() != 0 ? sb : -1);
		
	}
	
	public static void dijkstra() {
		minDist = new int[n + 1];
		Arrays.fill(minDist, -1);
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		minDist[x] = 0;
		q.offer(new int[] { x, minDist[x] });
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int next : list[cur[0]]) {
				if(minDist[next] != -1) continue;
				
				minDist[next] = cur[1] + 1;
				q.offer(new int[] { next, minDist[next] });
			}
		}
	}
	
}
