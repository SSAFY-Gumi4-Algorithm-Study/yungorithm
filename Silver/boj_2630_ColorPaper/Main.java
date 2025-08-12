import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] paper;
	static int blue, white;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0, 0, n);
		
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	public static void cut(int row, int col, int size) {
		
		int color = paper[row][col];
		boolean sameColor = true;
		
		// 현재 종이가 모두 같은 색으로 이루어져있는지 확인
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(paper[i][j] != color) {
					sameColor = false;
					break;
				}
			}
			if(!sameColor) {
				break;
			}
		}
		
		// 색상이 모두 같으면 개수세고 종료
		if(sameColor) {
			if(color == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		
		// 색상이 다르다면 영역을 4등분하여 재귀
		int newSize = size / 2;
		// 왼쪽 위 사각형
		cut(row, col, newSize);
		// 오른쪽 위 사각형
		cut(row, col + newSize, newSize);
		// 왼쪽 아래 사각형
		cut(row + newSize, col, newSize);
		// 오른쪽 아래 사각
		cut(row + newSize, col + newSize, newSize);
	}

}
