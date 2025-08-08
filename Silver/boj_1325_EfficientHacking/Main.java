import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		for(int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		
		cnt = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			dfs(i);
		}
		
		
		int max = 0;
		for(int i = 1; i <= n; i++) {
			if(cnt[i] > max) {
				max = cnt[i];
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(cnt[i] == max) {
				sb.append(i + " ");
			}
		}

		System.out.print(sb.toString());
		
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		for(int i : list[start]) {
			if(!visited[i]) {
				cnt[i]++;
				dfs(i);
			}
		}
	}

}
