import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] population;
	static boolean[] selectedA;
	static ArrayList<Integer>[] list;
	static int result;	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		population = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt; j++) {
				int a = Integer.parseInt(st.nextToken());
				
				list[i].add(a);
			}
		}
		
		selectedA = new boolean[n + 1];
		result = Integer.MAX_VALUE;
		
		dfs(1);
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		
	}
	
	public static void dfs(int idx) {
		if(idx == n + 1) {
			if(bfs(true) && bfs(false)) {
				int popA = getPop(true);
				int popB = getPop(false);
				
				result = Math.min(result, Math.abs(popA - popB));
			}
			
			return;
		}
		
		selectedA[idx] = true;
		dfs(idx + 1);
		
		selectedA[idx] = false;
		dfs(idx + 1);
	}
	
	public static boolean bfs(boolean isA) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];
		
		int start = -1;
		for(int i = 1; i <= n; i++) {
			if(selectedA[i] == isA) {
				start = i;
				break;
			}
		}
		
		if(start == -1) {
			return false;
		}
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : list[cur]) {
				if(visited[next]) {
					continue;
				}
				
				if(selectedA[next] != isA) {
					continue;
				}
				
				q.offer(next);
				visited[next] = true;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(selectedA[i] == isA && !visited[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int getPop(boolean isA) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			if(selectedA[i] == isA) {
				sum += population[i];
			}
		}
		
		return sum;
	}

}
