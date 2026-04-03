import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, cnt;
	static int[] arr;
	static boolean[] visited, finished;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			arr = new int[n + 1];
			for(int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 0;
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			for(int i = 1; i <= n; i++) {
				if(!finished[i]) dfs(i);
			}
			
			sb.append(n - cnt).append("\n");
		}
		
		System.out.println(sb);

	}
	
	public static void dfs(int node) {
		visited[node] = true;
		
		int next = arr[node];
		
		if(!visited[next]) {
			dfs(next);
		} else {
			if(!finished[next]) {
				cnt++;
				while(node != next) {
					cnt++;
					next = arr[next];
				}
			}
		}
		
		finished[node] = true;
	}

}
