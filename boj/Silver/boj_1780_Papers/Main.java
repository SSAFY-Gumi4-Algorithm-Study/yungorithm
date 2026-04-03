import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int[] cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = new int[3];
		cut(0, 0, n);
		
		sb.append(cnt[0]).append("\n").append(cnt[1]).append("\n").append(cnt[2]);
		
		System.out.println(sb);
		
	}
	
	public static void cut(int row, int col, int size) {
		if(numCheck(row, col, size)) {
			if(arr[row][col] == -1) {
				cnt[0]++;
			} else if(arr[row][col] == 0) {
				cnt[1]++;
			} else {
				cnt[2]++;
			}
			return;
		}
		
		int newSize = size / 3;
		
		cut(row, col, newSize);
		cut(row, col + newSize, newSize);
		cut(row, col + newSize * 2, newSize);
		
		cut(row + newSize, col, newSize);
		cut(row + newSize, col + newSize, newSize);
		cut(row + newSize, col + newSize * 2, newSize);
		
		cut(row + newSize * 2, col, newSize);
		cut(row + newSize * 2, col + newSize, newSize);
		cut(row + newSize * 2, col + newSize * 2, newSize);
	}
	
	public static boolean numCheck(int row, int col, int size) {
		int num = arr[row][col];
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(num != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
}
