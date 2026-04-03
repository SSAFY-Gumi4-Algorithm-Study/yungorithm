import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static boolean check[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int result = 0;
		
		List<Integer> list[] = new ArrayList[n + 1];
		for(int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();			
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		check = new boolean[n + 1];
		check[1]= true;
		dfs(1, 0, list);
		for(int i = 2; i < check.length; i++) {
			if(check[i]) {
				result++;
			}
		}
		
		System.out.println(result);
		
	}
	
	public static void dfs(int start, int depth, List<Integer> list[]) {
		if(depth == 2) {
			return;
		}
		for(int i = 0; i < list[start].size(); i++) {
			int next = list[start].get(i);
			check[next] = true;
			dfs(next, depth + 1, list);
		}
	}

}
