import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] board;
	static int min = 64;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		board = new char[n][m];
		for(int i = 0; i < n; i++) {
			char[] ch= br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				board[i][j] = ch[j];
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
		// 경우의 수를 생각해봐야하나
		// 우선 8 * 8 배열을 확인하고 첫 칸의 색 확인하고
		// 다음 색이 다르면 continue, 같으면 cnt++
		// 그리고 색깔 변경해서 그 다음 색 확인
		// 경우의 수 만큼 배열을 만들어서 결과를 출력해야할까
		// 어떻게 하는게 좋을까
		
		int cnt = 0;
		char startPoint = board[row][col];
		
		for(int i = row; i < row + 8; i++) {
			for(int j = col; j < col + 8; j++) {
				if(board[i][j] != startPoint) {
					cnt++;
				}
				
				if(startPoint == 'B') {
					startPoint = 'W';
				} else {
					startPoint = 'B';
				}
			}
			
			if(startPoint == 'B') {
				startPoint = 'W';
			} else {
				startPoint = 'B';
			}
		}
		
		cnt = Math.min(cnt, 64 - cnt);
		
		min = Math.min(cnt, min);
		
	}

}
