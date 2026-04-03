import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		arr = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dfs(i, j, n);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int x, int y, int size) {
		if((x / size) % 3 == 1 && (y / size) % 3 == 1) {
			arr[x][y] = ' ';
		} else if(size == 1) {
			arr[x][y] = '*';
		} else {
			dfs(x, y, size / 3);
		}
	}

}
