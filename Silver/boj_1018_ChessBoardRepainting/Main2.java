import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] board;
	static int min = 64;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		board = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				if(str.charAt(j) == 'B') {
					board[i][j] = true;
				} else {
					board[i][j] = false;
				}
			}
		}
		
		for(int i = 0; i < n - 7; i ++) {
			for(int j = 0; j < m - 7; j++) {
				find(i, j);
			}
		}
		
		System.out.println(min);
		
	}
	
	public static void find(int row, int col) {
		
		int cnt = 0;
		boolean startPoint = board[row][col];
		
		for(int i = row; i < row + 8; i++) {
			for(int j = col; j < col + 8; j++) {
				if(board[i][j] != startPoint) {
					cnt++;
				}
				
				startPoint = !startPoint;
			}
			
			startPoint = !startPoint;
		}
		
		cnt = Math.min(cnt, 64 - cnt);
		
		min = Math.min(cnt, min);
		
	}

}
