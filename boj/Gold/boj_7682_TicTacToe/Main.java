import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			if(s.equals("end")) break;
			
			arr = new char[3][3];
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					arr[i][j] = s.charAt(3 * i + j);
				}
			}
			
			if(isValid()) sb.append("valid\n");
			else sb.append("invalid\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static boolean win(char ch) {
	    // 가로
	    for (int i = 0; i < 3; i++) {
	        if (arr[i][0] == ch && arr[i][1] == ch && arr[i][2] == ch) return true;
	    }
    
	    // 세로
	    for (int j = 0; j < 3; j++) {
	        if (arr[0][j] == ch && arr[1][j] == ch && arr[2][j] == ch) return true;
	    }
    
	    // 대각선
	    if (arr[0][0] == ch && arr[1][1] == ch && arr[2][2] == ch) return true;
	    if (arr[0][2] == ch && arr[1][1] == ch && arr[2][0] == ch) return true;
    
	    return false;
	}

	public static boolean isValid() {
	    int x = 0;
      	int o = 0;
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (arr[i][j] == 'X') x++;
	            else if (arr[i][j] == 'O') o++;
	        }
	    }

	    if (!(x == o || x == o + 1)) return false;

	    boolean xWin = win('X');
	    boolean oWin = win('O');

	    if (xWin && oWin) return false;
	    if (xWin) return x == o + 1;
	    if (oWin) return x == o;

	    return x + o == 9;
	}

}
