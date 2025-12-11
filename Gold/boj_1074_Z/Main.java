import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, n);
		int result = 0;
		
		while(true) {
			if(size == 1) {
				break;
			}
			
			size /= 2;
			
			if(r < size && c < size) {
				continue;
			} else if(r < size && c >= size) {
				result += size * size * 1;
				c -= size;
			} else if(r >= size && c < size) {
				result += size * size * 2;
				r -= size;
			} else {
				result += size * size * 3;
				r -= size;
				c -= size;
			}
		}
		
		System.out.println(result);
		
	}
	
}
