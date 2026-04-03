import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, k, p, x, result;
	static int[] seg = {
			0b1111110, // 0
	        0b0110000, // 1
	        0b1101101, // 2
	        0b1111001, // 3
	        0b0110011, // 4
	        0b1011011, // 5
	        0b1011111, // 6
	        0b1110000, // 7
	        0b1111111, // 8
	        0b1111011  // 9
	};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		result = 0;
		
		for(int i = 1; i <= n; i++) {
			if(i == x) continue;
			
			int flips = diff(x, i, k);
			if(flips >= 1 && flips <= p) result++;
		}
		
		System.out.println(result);
		
	}
	
	public static int diff(int x, int y, int k) {
		int flips = 0;
		int a = x;
		int b = y;
		
		for(int i = 0; i < k; i++) {
			int dx = a % 10;
			int dy = b % 10;
			flips += Integer.bitCount(seg[dx] ^ seg[dy]);
			
			if(flips >= 1_000_000_000) break;
			
			a /= 10;
			b /= 10;
		}
		
		return flips;
	}
	
}
