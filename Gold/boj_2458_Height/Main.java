import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static ArrayList<Integer>[] heights, reverse;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		heights = new ArrayList[n + 1];
		reverse = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			heights[i] = new ArrayList<>();
			reverse[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			heights[a].add(b);
			reverse[b].add(a);
		}
		
		result = 0;
		for(int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			
			int bigger = dfs(i, reverse);
			int smaller = dfs(i, heights);
			
			if(bigger + smaller == n - 1) {
				result++;
			}
		}
		
		System.out.println(result);
		
	}
	
	public static int dfs(int start, ArrayList<Integer>[] list) {
		int cnt = 0;
		
		for(int next : list[start]) {
			if(visited[next]) {
				continue;
			}
			
			visited[next] = true;
			cnt++;
			cnt += dfs(next, list);
		}
		
		return cnt;
	}

}
