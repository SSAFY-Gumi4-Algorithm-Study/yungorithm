import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			
			if(str.equals("0")) {
				break;
			}
			
			int cnt = 0;
			
			if(str.length() % 2 == 0) {
				for(int i = 0; i < str.length() / 2; i++) {
					char ch1 = str.charAt(i);
					char ch2 = str.charAt(str.length() - 1 - i);
					if(ch1 == ch2) {
						cnt++;
					}
				}
				if(cnt == str.length() / 2) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			} else {
				for(int i = 0; i < (str.length() - 1) / 2; i++) {
					char ch1 = str.charAt(i);
					char ch2 = str.charAt(str.length() - 1 - i);
					if(ch1 == ch2) {
						cnt++;
					}
				}
				if(cnt == (str.length() - 1) / 2) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
			
		}
		
	}
	
}
