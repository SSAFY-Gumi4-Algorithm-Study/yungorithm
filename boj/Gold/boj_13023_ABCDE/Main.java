import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static boolean flag;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		flag = false;
		for(int i = 0; i < n; i++) {
			visited = new boolean[n];
			dfs(i, 1);

			if(flag) {
				System.out.println(1);
				return;
			}
		}

		System.out.println(0);
        
    }

	public static void dfs(int idx, int depth) {
		if(depth == 5) {
			flag = true;
			return;
		}

		visited[idx] = true;
		for(int next : list[idx]) {
			if(!visited[next]) {
				dfs(next, depth + 1);
			}
		}

		visited[idx] = false;
	}
    
}
