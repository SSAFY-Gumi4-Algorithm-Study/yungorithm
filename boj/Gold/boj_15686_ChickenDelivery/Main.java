import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] map;
	static ArrayList<int[]> houses;
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> chosen;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		houses = new ArrayList<>();
		chicken = new ArrayList<>();
		chosen = new ArrayList<>();
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					houses.add(new int[] { i, j });
				} else if(map[i][j] == 2) {
					chicken.add(new int[] { i, j });
				}
			}
		}
		
		visited = new boolean[chicken.size()];
		dfs(0, 0);
		sb.append(result);
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int start, int cnt) {
		if(cnt == m) {
			int sum = 0;
			for (int[] house : houses) {
				int min = Integer.MAX_VALUE;
				for (int[] choice : chosen) {
					int dist = Math.abs(house[0] - choice[0]) + Math.abs(house[1] - choice[1]);
					min = Math.min(min, dist);
				}
				sum += min;
			}
			
			result = Math.min(result, sum);
			return;
		}
		
		for(int i = start; i < chicken.size(); i++) {
			visited[i] = true;
			chosen.add(chicken.get(i));
			dfs(i + 1, cnt + 1);
			chosen.remove(chosen.size() - 1);
			visited[i] = false;
		}
	}

}
