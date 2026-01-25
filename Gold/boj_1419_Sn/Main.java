import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int l = Integer.parseInt(br.readLine());
		int r = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int result = solve(r, k) - solve(l - 1, k);
		
		System.out.println(result);
		
	}
	
	public static int solve(int r, int k) {
		if(r <= 0) return 0;
		
		switch(k) {
		case 2:
			if(r < 3) return 0;
			return r - 2;
		case 3:
			if(r < 6) return 0;
			return r / 3 - 1;
		case 5:
			if(r < 15) return 0;
			return r / 5 - 2;
		case 4:
			if(r < 10) return 0;
			
			int cnt = (r / 2) - (9 / 2);
			if(r >= 12) cnt--;
			return cnt;
		}
		
		return 0;
	}
	
}
