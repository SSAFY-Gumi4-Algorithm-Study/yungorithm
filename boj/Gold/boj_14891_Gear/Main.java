import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int k;
	static int[][] sawteeth;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sawteeth = new int[4][8];
		for(int i = 0; i < 4; i++) {
			String s = br.readLine();
			for(int j = 0; j < 8; j++) {
				sawteeth[i][j] = s.charAt(j) - '0';
			}
		}
		
		k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());
			
			checkRight(num + 1, -1 * direction);
			checkLeft(num - 1, -1 * direction);
			rotate(num, direction);
		}
		
		int result = sawteeth[0][0] + sawteeth[1][0] * 2 + sawteeth[2][0] * 4 + sawteeth[3][0] * 8;
		System.out.println(result);
		
	}
	
	public static void rotate(int num, int direction) {
		if(direction == 1) {
			int tmp = sawteeth[num][7];
			
			for(int i = 7; i > 0; i--) {
				sawteeth[num][i] = sawteeth[num][i - 1];
			}
			
			sawteeth[num][0] = tmp;
		} else {
			int tmp = sawteeth[num][0];
			
			for(int i = 0; i < 7; i++) {
				sawteeth[num][i] = sawteeth[num][i + 1];
			}
			
			sawteeth[num][7] = tmp;
		}
	}
	
	public static void checkRight(int num, int direction) {
		if(num < 4 && sawteeth[num - 1][2] != sawteeth[num][6]) {
			checkRight(num + 1, -1 * direction);
			rotate(num, direction);
		}
	}
	
	public static void checkLeft(int num, int direction) {
		if(num >= 0 && sawteeth[num][2] != sawteeth[num + 1][6]) {
			checkLeft(num - 1, -1 * direction);
			rotate(num, direction);
		}
	}

}
