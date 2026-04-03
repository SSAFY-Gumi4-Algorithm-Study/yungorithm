import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] quadTree;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 
		 int n = Integer.parseInt(st.nextToken());
		 
		 quadTree = new int[n][n];
		 for(int i = 0; i < n; i++) {
			 String str = br.readLine();
			 for(int j = 0; j < n; j++) {
				 quadTree[i][j] = Character.getNumericValue(str.charAt(j));
			 }
		 }

		 dfs(0, 0, n);
		 
		 System.out.println(sb);

	}
	
	public static void dfs(int x, int y, int size) {
		if(isPossible(x, y, size)) {
			sb.append(quadTree[x][y]);
			return;
		}
		
		int newSize = size / 2;
		
		sb.append("(");
		dfs(x, y, newSize);
		dfs(x, y + newSize, newSize);
		dfs(x + newSize, y, newSize);
		dfs(x + newSize, y + newSize, newSize);
		sb.append(")");
		
	}
	
	public static boolean isPossible(int x, int y, int size) {
		int tmp = quadTree[x][y];
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(tmp != quadTree[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
