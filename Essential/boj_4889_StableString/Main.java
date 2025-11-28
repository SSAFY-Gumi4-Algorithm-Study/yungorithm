import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = 1;
		while(true) {
			String s = br.readLine();
			
			if(s.startsWith("-")) break;
			
			sb.append(tc++).append(". ");
			
			int open = 0;
			int changed = 0;
			int size = s.length();
			
			for(int i = 0; i < size; i++) {
				char c = s.charAt(i);
				
				if(c == '{') open++;
				else {
					if(open > 0) open--;
					else {
						changed++;
						open++;
					}
				}
			}
			
			changed += open / 2;
			sb.append(changed).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
