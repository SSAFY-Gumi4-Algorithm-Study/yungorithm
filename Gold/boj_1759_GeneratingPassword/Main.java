import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int l, c;
	static char[] code, password;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		code = new char[c];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < c; i++) {
			code[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(code);
		
		password = new char[l];
		dfs(0, 0);
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int start, int depth) {
		if(depth == l) {
			if(isValid(password)) {
				for(char c : password) {
					sb.append(c);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		for(int i = start; i < c; i++) {
			password[depth] = code[i];
			dfs(i + 1, depth + 1);
		}
	}
	
	public static boolean isValid(char[] password) {
		int consonant = 0;
		int vowel = 0;
		
		for(int i = 0; i < password.length; i++) {
			if(password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u') {
				vowel++;
			} else {
				consonant++;
			}
		}
		
		if(consonant >= 2 && vowel >= 1) {
			return true;
		}
		
		return false;
	}

}
