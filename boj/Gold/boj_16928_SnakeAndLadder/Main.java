import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[] arr, dist;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[101];
		for(int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			arr[from] = to;
		}
		
		bfs();
		
		System.out.println(dist[100]);
		
	}
	
	public static void bfs() {
		dist = new int[101];
		Arrays.fill(dist, -1);
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		q.offer(1);
		dist[1] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == 100) return;
			
			for(int i = 1; i <= 6; i++) {
				int next = cur + i;
				
				if(next > 100) continue;
				
				if(arr[next] != 0) next = arr[next];
				
				if(dist[next] != -1) continue;
				dist[next] = dist[cur] + 1;
				
				if(next == 100) return;
				q.offer(next);
			}
		}
	}
	
}
