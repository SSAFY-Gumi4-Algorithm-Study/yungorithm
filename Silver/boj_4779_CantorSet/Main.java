import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
		
		String s = "";
		while((s = br.readLine()) != null)  {
			int n = Integer.parseInt(s);
			int len  = (int) Math.pow(3, n);
			
			char[] arr = new char[len];
			for(int i = 0; i < len; i++) {
				arr[i] = '-';
			}
			
			call(0, len, arr);
			
			System.out.println(arr);
		}
		
		
	}

	public static void call(int start, int len, char[] arr) {
		if(len == 1) {
			return;
		}
		
		len /= 3;
		for(int i = start + len; i < start + len * 2; i++) {
			arr[i] = ' ';
		}
		
		call(start, len, arr);
		
		call(start + len * 2, len, arr);
	}
	
}
